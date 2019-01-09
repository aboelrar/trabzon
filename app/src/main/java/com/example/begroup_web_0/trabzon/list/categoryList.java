package com.example.begroup_web_0.trabzon.list;

public class categoryList {
    int id;
    float Ratings;
    String Name,img;

    public categoryList(int id, String img, float ratings, String name) {
        this.id = id;
        this.img = img;
        Ratings = ratings;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getRatings() {
        return Ratings;
    }

    public void setRatings(float ratings) {
        Ratings = ratings;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
