package com.example.myapplication;

public class Cards {
    int image;
    String category;
    float price;

    public Cards(int image, String category, float price){
        this.image = image;
        this.category = category;
        this.price = price;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
