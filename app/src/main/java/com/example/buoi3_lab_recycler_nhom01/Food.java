package com.example.buoi3_lab_recycler_nhom01;

public class Food {
    private String name;
    private int img_resID;
    private String description;
    private Double price;

    public Food(String name, int img_resID, String description, Double price) {
        this.name = name;
        this.img_resID = img_resID;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_resID() {
        return img_resID;
    }

    public void setImg_resID(int img_resID) {
        this.img_resID = img_resID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
