package com.gmail.rgizmalkov.dev.validation.core.resolver;


import com.gmail.rgizmalkov.dev.validation.core.Validator;
import com.gmail.rgizmalkov.dev.validation.core.additional.Status;
import com.gmail.rgizmalkov.dev.validation.core.meta.Nonnull;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationAnswer;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationExecutor;
import com.gmail.rgizmalkov.dev.validation.core.validator.impl.BaseValidationAnswer;
import com.gmail.rgizmalkov.dev.validation.core.validator.impl.BaseValidationMessage;

import static com.gmail.rgizmalkov.dev.validation.core.additional.Status.status;

/**
 * Created by romanizmalkov on 14.06.17.
 */
public class NonnullValidationResolver implements ValidationExecutor<Object, Nonnull> {

    public ValidationAnswer<Object> validate(Object vo, Nonnull ao) {
        boolean result = vo != null;
        return new BaseValidationAnswer<Object>
                (
                        status(result),
                        ao.level(),
                        new BaseValidationMessage(ao.title(), result ? ao.success() : ao.error())
                        , vo
                );
    }
}
