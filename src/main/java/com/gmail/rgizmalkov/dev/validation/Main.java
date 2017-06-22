package com.gmail.rgizmalkov.dev.validation;

import com.gmail.rgizmalkov.dev.validation.core.additional.ValidationTarget;
import com.gmail.rgizmalkov.dev.validation.core.builder.pipeline.process.QueuePipeline;
import com.gmail.rgizmalkov.dev.validation.core.validator.ValidationObject;
import com.gmail.rgizmalkov.dev.validation.example.ClassA;
import com.gmail.rgizmalkov.dev.validation.example.ClassC;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
//
//        Stream<Integer> stream = Stream.<Integer>builder().build();
//        stream.filter()
//
//
//        Validator123 validator123 = Validation123.job()
//                .inline()
//                .circling(false)
//                .deep()
//                .limit(10)
//                .filter()
//                .target()
//                .validate(new Object());
        List<ValidationObject<?>> objects = new LinkedList<>();
        QueuePipeline.buildTree(new ClassC(), objects, ValidationTarget.FIELD);
        System.out.println(objects);
    }
}
