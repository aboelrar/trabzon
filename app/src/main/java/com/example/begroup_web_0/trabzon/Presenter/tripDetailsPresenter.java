package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.Model.tripDetailsModel;
import com.example.begroup_web_0.trabzon.interfacee.tripDetailsMvp;

import me.relex.circleindicator.CircleIndicator;

public class tripDetailsPresenter implements tripDetailsMvp.interfaces.presenter {
    private tripDetailsMvp.interfaces.Model model;
    private tripDetailsMvp.interfaces.View views;
    TextView name,descripition;
    String id;
    Context context;
    RecyclerView recyclerView;
    ViewPager viewPager;
    CircleIndicator circleIndicator;


        public tripDetailsPresenter(tripDetailsMvp.interfaces.View view, Context context, TextView name, TextView descripition, String id,ViewPager viewPager,CircleIndicator circleIndicator) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        this.name=name;
        this.descripition=descripition;
        this.viewPager=viewPager;
        this.circleIndicator=circleIndicator;
        this.id=id;
        initPresenter();
    }
    private void initPresenter() {
        model = new tripDetailsModel();

    }

    @Override
    public void getData() {
            model.getdata(viewPager,context,circleIndicator,id);
    }

    @Override
    public void getSecondData() {
        String details=model.getSecondData(name,descripition,context,id);

    }
}
