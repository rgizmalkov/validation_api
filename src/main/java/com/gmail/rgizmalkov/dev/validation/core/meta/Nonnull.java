package com.gmail.rgizmalkov.dev.validation.core.meta;


import com.gmail.rgizmalkov.dev.validation.core.additional.error.ValidationErrorLevel;
import com.gmail.rgizmalkov.dev.validation.core.resolver.NonnullValidationResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by romanizmalkov on 14.06.17.
 */

@Validation
@ValidationResolver(validator = NonnullValidationResolver.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnull {
    ValidationErrorLevel level() default ValidationErrorLevel.CRITICAL;
    String title() default "Null validation";
    String error() default "Object is Null!";
    String success() default "Non null object!";
}
