package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.countryModel;
import com.example.begroup_web_0.trabzon.Model.homeModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.list.sliderList;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class homePresenter implements MVP.interfaces.presenter {
    private MVP.interfaces.Model model;
    private MVP.interfaces.View views;
    Context context;
    RecyclerView recyclerView,recyclerView1,recyclerView2,recyclerView3;
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    public homePresenter(MVP.interfaces.View view, Context context, RecyclerView recyclerView, RecyclerView recyclerView1, RecyclerView recyclerView2, RecyclerView recyclerView3, ViewPager  viewPager,CircleIndicator circleIndicator) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        this.recyclerView1=recyclerView1;
        this.recyclerView2=recyclerView2;
        this.recyclerView3=recyclerView3;
        this.viewPager=viewPager;
        this.circleIndicator=circleIndicator;
        initPresenter();
    }
    private void initPresenter() {
        model = new homeModel();
    }
    @Override
    public void getData() {
        ArrayList<homeModel> mylist=model.getdata(recyclerView,context);
    }

    @Override
    public void getSecondData() {
        ArrayList<homeModel> mylisttwo=model.getSeconddata(recyclerView1,context);

    }

    @Override
    public void getThirdData() {
        ArrayList<homeModel> mylist=model.getThirddata(recyclerView2,context);
    }

    @Override
    public void getForthData() {
        ArrayList<homeModel> mylist=model.getFourthdata(recyclerView3,context);
    }

    @Override
    public void getFifthData() {
        ArrayList<sliderList>mylist=model.getFifthdata(viewPager,context,circleIndicator);
    }
}
