package com.example.byciclestore;

import java.io.Serializable;

public class Shoe implements Serializable {
    private int img;
    private String name;
    private double price;
    private String type;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Shoe(String name,int img, double price, String type) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
