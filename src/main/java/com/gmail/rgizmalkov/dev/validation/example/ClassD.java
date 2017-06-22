package com.gmail.rgizmalkov.dev.validation.example;

import com.gmail.rgizmalkov.dev.validation.core.meta.Nonnull;
import lombok.ToString;

/**
 * Created by romanizmalkov on 14.06.17.
 */
@ToString
public class ClassD {
    @Nonnull
    private Integer val1 = 10;
    @Nonnull
    private Long val2 = 11L;
}
