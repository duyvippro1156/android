package com.example.kiemtra;

import android.widget.ListView;

public class ListViewBean {
    int image;
    String langName;
    int price;
    public ListViewBean(){
    }
    public ListViewBean(int image, String langName, int price){
        super();
        this.image = image;
        this.price = price;
        this.langName = langName;
    }
    public int getImage(){
        return image;
    }
    public void setImage(int image){
        this.image = image;
    }
    public String getLangName(){
        return langName;
    }
    public void setLangName(String langName){
        this.langName = langName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}