package com.gmail.rgizmalkov.dev.validation.core.validator;

import lombok.ToString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
public interface ValidationObject<Type> {
    ValidationAnnotation[] annotatedBy();
    Field classField();
    Type instance();
}
