package com.gmail.rgizmalkov.dev.validation.example;

import com.gmail.rgizmalkov.dev.validation.core.meta.Nonnull;
import lombok.ToString;

/**
 * Created by romanizmalkov on 14.06.17.
 */
@ToString
public class ClassA {
    @Nonnull
    private ClassB classB = new ClassB();
    @Nonnull
    private ClassC classC= new ClassC();;

//    @Nonnull
//    private ClassD classD = new ClassD();
//
//    @Nonnull
//    private ClassE classE = new ClassE();
}
