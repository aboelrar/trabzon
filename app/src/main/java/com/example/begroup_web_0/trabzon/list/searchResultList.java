package com.example.begroup_web_0.trabzon.list;

public class searchResultList {
    int id;
    String samaimg;
    double value;
    String tripTitle,tripDescription,peoplenum;

    public searchResultList(int id, String samaimg, double value, String tripTitle, String tripDescription, String peoplenum) {
        this.id = id;
        this.samaimg = samaimg;
        this.value = value;
        this.tripTitle = tripTitle;
        this.tripDescription = tripDescription;
        this.peoplenum = peoplenum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSamaimg() {
        return samaimg;
    }

    public void setSamaimg(String samaimg) {
        this.samaimg = samaimg;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }
}
