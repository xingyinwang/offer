package com.java.annotationtest;

import java.lang.annotation.*;

/**
 * Created by Kode on 2019/5/4.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    public enum Color{BULE, RED, GREEN};

    Color fruitColr() default Color.GREEN;
}
