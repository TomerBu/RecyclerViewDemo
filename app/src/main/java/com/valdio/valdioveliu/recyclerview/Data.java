package com.valdio.valdioveliu.recyclerview;


public class Data {
    private String title;
    private String description;
    private int imageId;

    Data(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getImageId() {
        return imageId;
    }



}

