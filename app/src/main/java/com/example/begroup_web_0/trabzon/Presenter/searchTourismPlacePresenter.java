package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.questionModel;
import com.example.begroup_web_0.trabzon.Model.searchModel;
import com.example.begroup_web_0.trabzon.Model.searchTourismPlaceModel;
import com.example.begroup_web_0.trabzon.interfacee.questionMvp;
import com.example.begroup_web_0.trabzon.interfacee.tourismPlaceMvp;

import java.util.ArrayList;

public class searchTourismPlacePresenter implements tourismPlaceMvp.interfaces.presenter{
    private tourismPlaceMvp.interfaces.Model model;
    private tourismPlaceMvp.interfaces.View views;
    Context context;
    int resource;
    RecyclerView recyclerView;
    String filter,CategoryId,countryId;


    public searchTourismPlacePresenter(tourismPlaceMvp.interfaces.View view, Context context, RecyclerView recyclerView,int resource,String filter,String CategoryId,String countryId) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        this.resource=resource;
        this.CategoryId=CategoryId;
        this.countryId=countryId;
        this.filter=filter;
        initPresenter();
    }
    private void initPresenter() {
        model = new searchTourismPlaceModel();

    }
    @Override
    public void getData() {
        ArrayList<searchModel> mylist=model.getdata(recyclerView,context,resource,filter,CategoryId,countryId);
    }



    @Override
    public void getSecondData() {
        ArrayList<searchModel> mylist=model.getSeconddata(recyclerView,context,resource,filter,CategoryId,countryId);

    }
}
