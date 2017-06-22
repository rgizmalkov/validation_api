package com.gmail.rgizmalkov.dev.validation.core.validator;

import com.gmail.rgizmalkov.dev.validation.core.additional.Status;
import com.gmail.rgizmalkov.dev.validation.core.additional.error.ValidationErrorLevel;

public interface ValidationAnswer<Type> {
    Status status();
    ValidationErrorLevel level();
    ValidationMessage message();
    Type validated();
}
