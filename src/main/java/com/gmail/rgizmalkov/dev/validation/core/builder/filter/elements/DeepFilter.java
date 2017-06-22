package com.gmail.rgizmalkov.dev.validation.core.builder.filter.elements;

import com.gmail.rgizmalkov.dev.validation.core.builder.filter.AbstractFilter;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class DeepFilter<T> extends AbstractFilter<T> {
    private long value = -1;
    private final long deep;

    public DeepFilter(long deep) {
        this.deep = deep;
    }

    @Override
    public synchronized boolean test(T o) {
        if(deep == -1) return true;
        value = value + 1;
        return value <= deep;
    }
}
