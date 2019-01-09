package com.example.begroup_web_0.trabzon.list;

public class commentList {
    String name,comment;
    int id;

    public commentList(int id,String name, String comment) {
        this.name = name;
        this.comment = comment;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}