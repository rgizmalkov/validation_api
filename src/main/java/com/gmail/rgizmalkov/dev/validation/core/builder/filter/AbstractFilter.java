package com.gmail.rgizmalkov.dev.validation.core.builder.filter;

import java.util.Objects;

public abstract class AbstractFilter<Type> implements Filter<Type> {

    public abstract boolean test(Type type);

    @Override
    public Filter<Type> and(Filter<? super Type> filter) {
        Objects.requireNonNull(filter);
        return new AbstractFilter<Type>(){

            @Override
            public boolean test(Type type) {
                return AbstractFilter.this.test(type) && filter.test(type);
            }
        };
    }

    @Override
    public Filter<Type> or(Filter<? super Type> filter) {
        Objects.requireNonNull(filter);
        return new AbstractFilter<Type>(){

            @Override
            public boolean test(Type type) {
                return AbstractFilter.this.test(type) || filter.test(type);
            }
        };
    }
}
