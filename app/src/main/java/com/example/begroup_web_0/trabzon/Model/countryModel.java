package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.list.barList;
import com.example.begroup_web_0.trabzon.list.categoryList;
import com.example.begroup_web_0.trabzon.list.searchList;
import com.example.begroup_web_0.trabzon.list.searchResultList;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class countryModel implements MVP.interfaces.Model {
    public ArrayList getdata() {
        ArrayList<searchList>arrayList=new ArrayList<searchList>();
        arrayList.add(new searchList(1,"القاهره"));
        arrayList.add(new searchList(2,"الاسكندريه"));
        arrayList.add(new searchList(3,"طنطا"));
        arrayList.add(new searchList(4,"اسكندريه"));
        arrayList.add(new searchList(5,"شرم الشيخ"));
        arrayList.add(new searchList(7,"الغردقه"));
        return arrayList;
    }

    @Override
    public ArrayList getdata(RecyclerView recyclerView, Context context) {
        return null;
    }

    @Override
    public ArrayList getSeconddata(RecyclerView recyclerView, Context context) {
        return null;
    }

    @Override
    public ArrayList getThirddata(RecyclerView recyclerView, Context context) {
        return null;
    }

    @Override
    public ArrayList getFourthdata(RecyclerView recyclerView, Context context) {
        return null;
    }

    @Override
    public ArrayList getFifthdata(ViewPager ViewPager, Context context, CircleIndicator circleIndicator) {
        return null;
    }


}