package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.list.samaTripsList;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class samaTripModel  implements MVP.interfaces.Model {

    public ArrayList getdata() {
        ArrayList<samaTripsList>arrayList=new ArrayList<samaTripsList>();
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
        arrayList.add(new samaTripsList(1,1,"اسطنول","Aw77s","11/2/2010","55.33","05","10","30","30"));
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
