package com.gmail.rgizmalkov.dev.validation.core.builder.filter;

import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;

public class InlineElement<Type> extends AbstractFilter<ValidationObject<Type>> {

    @Override
    public boolean test(ValidationObject<Type> typeValidationObject) {
        return false;
    }
}
