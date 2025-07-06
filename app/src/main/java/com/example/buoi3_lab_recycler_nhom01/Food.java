package com.example.buoi3_lab_recycler_nhom01;

public class Food {
    private String name;
    private int img_resID;

    public Food(String name, int img_resID) {
        this.name = name;
        this.img_resID = img_resID;
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
}
