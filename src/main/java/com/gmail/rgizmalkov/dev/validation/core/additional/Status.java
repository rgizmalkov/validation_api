package com.gmail.rgizmalkov.dev.validation.core.additional;

public enum Status {
    OK,
    FAIL,
    SKIPPED;


    public static Status status(boolean b){
        return b ? OK : FAIL;
    }
}
