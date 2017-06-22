package com.gmail.rgizmalkov.dev.validation.core.additional.error;

public enum ValidationErrorLevel {
    INFO("info"),
    WARNING("warning"),
    CRITICAL("critical"),
    FATAL("fatal");

    private String value;

    ValidationErrorLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
