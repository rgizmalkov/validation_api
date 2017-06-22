package com.gmail.rgizmalkov.dev.validation.example;

import com.gmail.rgizmalkov.dev.validation.core.meta.Nonnull;
import lombok.ToString;

/**
 * Created by romanizmalkov on 14.06.17.
 */
@ToString
public class ClassE {
    @Nonnull
    private String str1 = "str1";
    @Nonnull
    private String str2 = "str2";
}
