package com.java.annotationtest;

/**
 * Created by Kode on 2019/5/4.
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColr = FruitColor.Color.GREEN)
    private String appleColor;

    @FruitProvider(id = 1, name = "宁夏高元帅", address = "吴忠市")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public void display() {
        System.out.println("水果的名字是：苹果");
    }
}
