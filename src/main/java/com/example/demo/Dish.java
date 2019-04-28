package com.example.demo;

import lombok.Data;

@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    
    public enum Type {MEAT,FISH,OTHER}
    
    //省略get set方法
}