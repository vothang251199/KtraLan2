package com.example.ktralan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Item_list   {

    int img;
    String ten;

    public Item_list(int img, String ten) {
        this.img = img;
        this.ten = ten;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}