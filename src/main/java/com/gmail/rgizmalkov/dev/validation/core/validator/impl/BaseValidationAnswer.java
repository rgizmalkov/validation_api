package com.gmail.rgizmalkov.dev.validation.core.validator.impl;

import com.gmail.rgizmalkov.dev.validation.core.additional.Status;
import com.gmail.rgizmalkov.dev.validation.core.additional.error.ValidationErrorLevel;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnswer;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationMessage;

public class BaseValidationAnswer<Type> implements ValidationAnswer<Type> {
    private Status status;
    private ValidationErrorLevel level;
    private ValidationMessage message;
    private Type validated;

    public BaseValidationAnswer(Status status, ValidationErrorLevel level, ValidationMessage message, Type validated) {
        this.status = status;
        this.level = level;
        this.message = message;
        this.validated = validated;
    }

    @Override
    public Status status() {
        return status;
    }

    @Override
    public ValidationErrorLevel level() {
        return level;
    }

    @Override
    public ValidationMessage message() {
        return message;
    }

    @Override
    public Type validated() {
        return validated;
    }
}
