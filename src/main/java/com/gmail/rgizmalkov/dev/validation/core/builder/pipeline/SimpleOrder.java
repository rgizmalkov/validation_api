package com.gmail.rgizmalkov.dev.validation.core.builder.pipeline;

public class SimpleOrder implements Order {
    public static final int MIN_ORDER = Integer.MIN_VALUE;
    public static final int MAX_ORDER = Integer.MAX_VALUE;

    private Integer order;

    private SimpleOrder(int order){
        this.order = order;
    }

    public static SimpleOrder order(int order){
        return new SimpleOrder(order);
    }

    @Override
    public int order() {
        return order;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) throw new NullPointerException();
        if(!(o instanceof Order)) throw new IllegalArgumentException();
        Order o1 = (Order) o;
        return this.order.compareTo(o1.order());
    }
}
