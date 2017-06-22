package com.gmail.rgizmalkov.dev.validation.core.additional;

public final class Deep {
    private long deep;

    private Deep(long deep) {
        this.deep = deep;
    }

    public static Deep self(){
        return new Deep(0);
    }

    public static Deep child(){
        return new Deep(1);
    }

    public static Deep childOfChildren(){
        return new Deep(2);
    }

    public static Deep all(){
        return new Deep(-1);
    }

    public static Deep nthGeneration(long generation){
        return new Deep(generation);
    }


    public long deep() {
        return deep;
    }
}
