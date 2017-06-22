package com.gmail.rgizmalkov.dev.validation.core.validator.impl;

import com.gmail.rgizmalkov.dev.validation.core.meta.ValidationResolver;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnnotation;

import java.lang.annotation.Annotation;
import java.util.Objects;

public class BaseValidationAnnotation implements ValidationAnnotation {
    private ValidationResolver resolver;
    private Annotation annotatedBy;

    public BaseValidationAnnotation(ValidationResolver resolver, Annotation annotatedBy) {
        Objects.requireNonNull(resolver);
        Objects.requireNonNull(annotatedBy);

        this.resolver = resolver;
        this.annotatedBy = annotatedBy;
    }

    @Override
    public ValidationResolver resolver() {
        return resolver;
    }

    @Override
    public Annotation annotatedBy() {
        return annotatedBy;
    }
}
