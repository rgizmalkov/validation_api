package com.gmail.rgizmalkov.dev.validation.core.builder.filter.elements;

import com.gmail.rgizmalkov.dev.validation.core.builder.filter.AbstractFilter;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;

public class EmptyFilter<T> extends AbstractFilter<T> {
    @Override
    public boolean test(T o) {
        return true;
    }
}
