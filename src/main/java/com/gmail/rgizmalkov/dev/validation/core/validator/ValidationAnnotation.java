package com.gmail.rgizmalkov.dev.validation.core.validator;

import com.gmail.rgizmalkov.dev.validation.core.meta.ValidationResolver;

import java.lang.annotation.Annotation;

public interface ValidationAnnotation {
     ValidationResolver resolver();
     Annotation annotatedBy();
}
