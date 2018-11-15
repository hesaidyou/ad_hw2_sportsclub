package com.example.liuyang.sportsclub_fragment;

public class Coach {
    private String name;
    private int imageId;

    public Coach(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
