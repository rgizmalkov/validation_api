package com.gmail.rgizmalkov.dev.validation.example;

import com.gmail.rgizmalkov.dev.validation.core.meta.Nonnull;
import lombok.ToString;

/**
 * Created by romanizmalkov on 14.06.17.
 */
@ToString
public class ClassB {
    @Nonnull
    private ClassC classC1= new ClassC();;
    @Nonnull
    private ClassC classC2= new ClassC();;
    @Nonnull
    private ClassC classC3= new ClassC();;
    @Nonnull
    private ClassD classD= new ClassD();;
}
