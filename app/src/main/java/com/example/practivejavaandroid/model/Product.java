package com.example.practivejavaandroid.model;

public class Product {
    private Integer image;
    private String name;

    public Product(Integer image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
