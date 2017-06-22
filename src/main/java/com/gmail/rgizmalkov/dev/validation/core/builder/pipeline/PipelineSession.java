package com.gmail.rgizmalkov.dev.validation.core.builder.pipeline;

import com.gmail.rgizmalkov.dev.validation.core.additional.Deep;
import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class PipelineSession {
    private Deep deep = Deep.all();
    private boolean circling = false;
    private boolean parallel = false;
    private ValidationTarget validationTarget = ValidationTarget.FIELD;

    public void deep(Deep deep) {
        this.deep = deep;
    }

    public void circling(boolean circling) {
        this.circling = circling;
    }

    public void parallel(boolean parallel) {
        this.parallel = parallel;
    }

    public void target(ValidationTarget validationTargets) {
        this.validationTarget = validationTargets;
    }

    public Deep getDeep() {
        return deep;
    }

    public boolean isCircling() {
        return circling;
    }

    public boolean isParallel() {
        return parallel;
    }

    public ValidationTarget getValidationTarget() {
        return validationTarget;
    }
}
