package com.gmail.rgizmalkov.dev.validation.core.validator.impl;

import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationMessage;

public class BaseValidationMessage implements ValidationMessage {
    private String reason;
    private String message;

    public BaseValidationMessage(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }

    @Override
    public String reason() {
        return reason;
    }

    @Override
    public String message() {
        return message;
    }
}
