package com.gmail.rgizmalkov.dev.validation.core.builder.filter.elements;

import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationUtils;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.AbstractFilter;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CirclingFilter extends AbstractFilter<Class<?>> {
    private volatile Set<Class<?>> parents = new HashSet<>();

    @Override
    public synchronized boolean test(Class<?> aClass) {
        if(ValidationUtils.isEndPoint(aClass)) return true;
        if(parents.contains(aClass)){
            return false;
        }else {
            parents.add(aClass);
            return true;
        }
    }
}
