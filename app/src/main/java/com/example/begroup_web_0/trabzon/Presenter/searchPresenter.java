package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.homeModel;
import com.example.begroup_web_0.trabzon.Model.searchModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.searchMvp;

import java.util.ArrayList;

public class searchPresenter implements searchMvp.presenter {
    private searchMvp.Model model;
    private searchMvp.View views;
    Context context;
    RecyclerView recyclerView;


    public searchPresenter(searchMvp.View view, Context context, RecyclerView recyclerView) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        initPresenter();
    }
    private void initPresenter() {
        model = new searchModel();

    }
    @Override
    public void getData() {
        ArrayList<searchModel> mylist=model.getdata(recyclerView,context);
    }


    @Override
    public void getSecondData() {

    }

}
