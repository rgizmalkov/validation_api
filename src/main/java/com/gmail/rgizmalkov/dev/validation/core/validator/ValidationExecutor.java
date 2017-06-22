package com.gmail.rgizmalkov.dev.validation.core.validator;

import java.lang.annotation.Annotation;

/**
 * Created by romanizmalkov on 13.06.17.
 */
public interface ValidationExecutor<V, A extends Annotation> {
    ValidationAnswer<V> validate(V validationObject, A annotation);
}
