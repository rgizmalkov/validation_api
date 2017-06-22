package com.gmail.rgizmalkov.dev.validation.core;

import com.gmail.rgizmalkov.dev.validation.core.additional.Deep;
import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationPhase;
import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.gmail.rgizmalkov.dev.validation.core.builder.filter.Filter;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnswer;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationResponse;

public interface Validator<Type> {
    Validator<Type> inline();
    Validator<Type> parallel();
    Validator<Type> deep(Deep deep);
    Validator<Type> target(ValidationTarget targets);
    Validator<Type> limit(long l);
    Validator<Type> filter(Filter<?> filter, ValidationPhase phase); // -> аннотация типа, уровень опасности
    Validator<Type> filterByObject(Filter<? extends ValidationObject<Type>> before); // -> аннотация типа, уровень опасности
    Validator<Type> filterByAnswer(Filter<? extends ValidationAnswer<Type>> after); // -> аннотация типа, уровень опасности
    Validator<Type> circling(boolean circling);
    ValidationResponse validate(Type obj);
}
