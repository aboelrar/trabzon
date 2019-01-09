package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.questionModel;
import com.example.begroup_web_0.trabzon.Model.searchModel;
import com.example.begroup_web_0.trabzon.Model.tourismPlaceModel;
import com.example.begroup_web_0.trabzon.interfacee.questionMvp;
import com.example.begroup_web_0.trabzon.interfacee.tourismPlaceMvp;

import java.util.ArrayList;

public class questionPresenter implements questionMvp.interfaces.presenter {
    private questionMvp.interfaces.Model model;
    private questionMvp.interfaces.View views;
    Context context;
    RecyclerView recyclerView;


    public questionPresenter(questionMvp.interfaces.View view, Context context, RecyclerView recyclerView) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        initPresenter();
    }
    private void initPresenter() {
        model = new questionModel();

    }
    @Override
    public void getData() {
        ArrayList<searchModel> mylist=model.getdata(recyclerView,context);
    }


    @Override
    public void getSecondData() {

    }
}
