package com.example.begroup_web_0.trabzon.list;

public class barList {
int id;
String name,img;

    public barList(int id, String img, String name) {
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
