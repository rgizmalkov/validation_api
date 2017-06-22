package com.gmail.rgizmalkov.dev.validation.core.meta;

import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationExecutor;

import java.lang.annotation.*;

/**
 * Created by romanizmalkov on 13.06.17.
 */

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationResolver {
    Class<? extends ValidationExecutor<?, ? extends Annotation>> validator();
}
