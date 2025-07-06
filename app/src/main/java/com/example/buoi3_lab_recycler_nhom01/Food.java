package com.example.buoi3_lab_recycler_nhom01;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Food implements Parcelable {
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


    protected Food(Parcel in) {
        name = in.readString();
        img_resID = in.readInt();
        description = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(img_resID);
        parcel.writeString(description);
        parcel.writeDouble(price);
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
