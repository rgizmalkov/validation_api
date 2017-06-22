package com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.process;

import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.gmail.rgizmalkov.dev.validation.core.meta.Validation;
import com.gmail.rgizmalkov.dev.validation.core.meta.ValidationResolver;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnnotation;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import com.gmail.rgizmalkov.dev.validation.core.validator.impl.BaseValidationAnnotation;
import com.gmail.rgizmalkov.dev.validation.core.validator.impl.BaseValidationObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class TargetFactory {

    static ValidationObject<?> validationObject(Field field, Object object, ValidationTarget validationTarget){
        switch (validationTarget){
            case CLASS: return clazz(field, object);
            case FIELD: return field(field, object);
            case METHOD: return method(field, object);
        }
        throw new IllegalArgumentException();
    }


    private static ValidationObject<?> field(Field field, Object object) {
        ValidationAnnotation[] va = validationAnnotationToClassField(field);
        return new BaseValidationObject<>(va, field, object);
    }

    private static ValidationAnnotation[] validationAnnotationToClassField(Field field) {
        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
        List<ValidationAnnotation> validationParameters = new ArrayList<ValidationAnnotation>(declaredAnnotations.length);

        for (Annotation declaredAnnotation : declaredAnnotations) {
            Class<? extends Annotation> aClass = declaredAnnotation.annotationType();
            Validation validation = aClass.getAnnotation(Validation.class);
            ValidationResolver validationResolver = aClass.getAnnotation(ValidationResolver.class);
            if(validation == null || validationResolver == null){
                continue;
            }
            validationParameters.add(new BaseValidationAnnotation(validationResolver, declaredAnnotation));
        }
        return validationParameters.toArray(new ValidationAnnotation[validationParameters.size()]);
    }

    private static ValidationObject<?> clazz(Field field, Object object) {
        return null;
    }

    private static ValidationObject<?> method(Field field, Object object) {
        return null;
    }
}
