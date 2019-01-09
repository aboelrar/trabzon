package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.searchModel;
import com.example.begroup_web_0.trabzon.Model.tourismPlaceModel;
import com.example.begroup_web_0.trabzon.interfacee.searchMvp;
import com.example.begroup_web_0.trabzon.interfacee.tourismPlaceMvp;

import java.util.ArrayList;

public class tourismPlacePresenter implements tourismPlaceMvp.interfaces.presenter {
    private tourismPlaceMvp.interfaces.Model model;
    private tourismPlaceMvp.interfaces.View views;
    Context context;
    RecyclerView recyclerView;
    String filter;

    public tourismPlacePresenter(tourismPlaceMvp.interfaces.View view, Context context, RecyclerView recyclerView,String filter) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        this.filter=filter;
        initPresenter();
    }
    private void initPresenter() {
        model = new tourismPlaceModel();

    }
    @Override
    public void getData() {
        ArrayList<searchModel> mylist=model.getdata(recyclerView,context,5,filter,null,null);
    }


    @Override
    public void getSecondData() {

    }
}
