package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;

import com.example.begroup_web_0.trabzon.Model.homeModel;
import com.example.begroup_web_0.trabzon.Model.samaTripModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;

import java.util.ArrayList;

public class samaTripsPresenter implements MVP.interfaces.presenter {
    private MVP.interfaces.Model model;
    private MVP.interfaces.View views;
    Context context;


    public samaTripsPresenter(MVP.interfaces.View view, Context context) {
        this.views = view;
        this.context=context;
        initPresenter();
    }
    private void initPresenter() {
        model = new samaTripModel();
    }
    @Override
    public void getData() {
        ArrayList<samaTripModel> mylist=null;
    }

    @Override
    public void getSecondData() {

    }

    @Override
    public void getThirdData() {

    }

    @Override
    public void getForthData() {

    }

    @Override
    public void getFifthData() {

    }
}
