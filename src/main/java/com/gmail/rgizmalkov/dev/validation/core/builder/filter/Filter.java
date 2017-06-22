package com.gmail.rgizmalkov.dev.validation.core.builder.filter;

public interface Filter<Type> {

    boolean test(Type object);

    Filter<Type> and(Filter<? super  Type> filter);

    Filter<Type> or(Filter<? super  Type> filter);
}
