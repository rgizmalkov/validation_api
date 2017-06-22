package com.gmail.rgizmalkov.dev.validation.core.impl;

import com.gmail.rgizmalkov.dev.validation.core.Validator;
import com.gmail.rgizmalkov.dev.validation.core.additional.Deep;
import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationPhase;
import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.PipelineSession;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.Filter;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnswer;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationResponse;
import com.google.common.collect.ImmutableSet;

import static com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.SimpleOrder.MIN_ORDER;
import static com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.SimpleOrder.order;

public class AbstractValidator<Type> implements Validator<Type> {
    private PipelineSession session;


    @Override
    public Validator<Type> inline() {
        session.parallel(false);
        return this;
    }

    @Override
    public Validator<Type> parallel() {
        session.parallel(true);
        return this;
    }

    @Override
    public Validator<Type> deep(Deep deep) {
        session.deep(deep);
        return this;
    }

    @Override
    public Validator<Type> target(ValidationTarget target) {
        session.target(target);
        return this;
    }

    @Override
    public Validator<Type> limit(long l) {
        return null;
    }

    @Override
    public Validator<Type> filter(Filter<?> filter, ValidationPhase phase) {
        return null;
    }

    @Override
    public Validator<Type> filterByObject(Filter<? extends ValidationObject<Type>> before) {
        return null;
    }

    @Override
    public Validator<Type> filterByAnswer(Filter<? extends ValidationAnswer<Type>> after) {
        return null;
    }

    @Override
    public Validator<Type> circling(boolean circling) {
        session.circling(circling);
        return this;
    }

    @Override
    public ValidationResponse validate(Type obj) {
        return null;
    }
}
