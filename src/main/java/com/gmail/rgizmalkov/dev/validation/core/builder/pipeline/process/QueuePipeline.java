package com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.process;

import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.Filter;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.elements.CirclingFilter;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.elements.EmptyFilter;
import com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.PipelineSession;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

import static com.gmail.rgizmalkov.dev.validation.core.additional.ValidationUtils.isEndPoint;

public class QueuePipeline<Type> implements Pipeline<ValidationObject<?>> {
    private volatile Iterable<ValidationObject<?>> needToValidate;
    private static Filter<Class<?>> circlingFiler = filter(true);

    public QueuePipeline(PipelineSession session, Object object) {
        Objects.requireNonNull(session);
        Objects.requireNonNull(object);

        this.circlingFiler = filter(session.isCircling());

        if (session.isParallel()) {
            wholeBuild(session, object);
        } else {
            lineBuild(session, object);
        }
    }

    private static Filter<Class<?>> filter(boolean circling) {
        return circling ? new CirclingFilter() : new EmptyFilter();
    }


    @Override
    public synchronized ValidationObject<?> next() {
        return call();
    }

    private ValidationObject<?> call() {
        return null;
    }

    private void wholeBuild(PipelineSession session, Object obj) {
        List<ValidationObject<?>> objects = new LinkedList<>();

        long deep = session.getDeep().deep();
        if (deep < -1) {
            this.needToValidate = Collections.emptyList();
            return;
        }
        if (deep == -1)
            buildTree(obj, objects, session.getValidationTarget());
        else {
            buildIterableTree(obj, objects, session.getValidationTarget(), deep);
        }
        this.needToValidate = objects;
    }


    private void lineBuild(PipelineSession session, Object obj) {

    }


    private static ValidationObject<?> validationObject(Field field, Object object, ValidationTarget validationTarget) {
        return TargetFactory.validationObject(field, object, validationTarget);
    }

    public static void buildTree(Object object, List<ValidationObject<?>> leaves, ValidationTarget target) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if(!circlingFiler.test(aClass)) return;
        for (Field field : fields) {
            ReflectionUtils.makeAccessible(field);
            Object leave = ReflectionUtils.getField(field, object);
            ValidationObject<?> leaveValidationObject = validationObject(field, leave, target);
            leaves.add(leaveValidationObject);
            if (leave != null && !isEndPoint(leave)) {
                buildTree(leave, leaves, target);
            }
        }
    }

    private void buildIterableTree(Object object, List<ValidationObject<?>> leaves, ValidationTarget target, long deep) {
        Collection<? extends ValidationObject<?>> part = getPart(object, target);
        deep--;
        leaves.addAll(part);

        for (; deep < 0; deep--) {
            for (ValidationObject<?> validationObject : part) {
                if (validationObject != null && !isEndPoint(validationObject.instance())) {
                    leaves.addAll(getPart(validationObject.instance(), target));
                }
            }
        }
    }

    private Collection<? extends ValidationObject<?>> getPart(Object object, ValidationTarget target) {
        List<ValidationObject<?>> objects = new LinkedList<>();

        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if (!circlingFiler.test(aClass)) return objects;
        for (Field field : fields) {
            ValidationObject<?> vo = getVo(field, object, target);
            objects.add(vo);
        }

        return objects;
    }


    private ValidationObject<?> getVo(Field field, Object object, ValidationTarget target) {
        ReflectionUtils.makeAccessible(field);
        Object leave = ReflectionUtils.getField(field, object);
        return validationObject(field, leave, target);
    }

}
