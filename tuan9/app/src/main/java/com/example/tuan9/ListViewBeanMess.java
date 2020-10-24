package com.example.tuan9;

public class ListViewBeanMess {
    int image;
    String langName;
    String mess;
    public ListViewBeanMess(){
    }
    public ListViewBeanMess(int image, String langName, String mess){
        super();
        this.image = image;
        this.langName = langName;
        this.mess = mess;

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
    public String getMess(){
        return mess;
    }
    public void setMess(String mess){
        this.mess = mess;
    }
}
