package com.gmail.rgizmalkov.dev.validation.core.validator.impl;

import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnnotation;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import lombok.ToString;

import java.lang.reflect.Field;

@ToString
public class BaseValidationObject<Type> implements ValidationObject<Type> {
    private ValidationAnnotation[] validationAnnotations;
    private Field classField;
    private Type object;

    public BaseValidationObject(ValidationAnnotation[] validationAnnotations, Field classField, Type object) {
        this.validationAnnotations = validationAnnotations;
        this.classField = classField;
        this.object = object;
    }

    @Override
    public ValidationAnnotation[] annotatedBy() {
        return validationAnnotations;
    }

    @Override
    public Field classField() {
        return classField;
    }

    @Override
    public Type instance() {
        return object;
    }
}
