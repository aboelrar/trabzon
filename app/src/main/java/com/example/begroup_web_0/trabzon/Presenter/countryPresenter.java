package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;

import com.example.begroup_web_0.trabzon.Model.countryModel;
import com.example.begroup_web_0.trabzon.Model.searchModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;

import java.util.ArrayList;

public class countryPresenter  implements MVP.interfaces.presenter {
    private MVP.interfaces.Model model;
    private MVP.interfaces.View views;
    Context context;


    public countryPresenter(MVP.interfaces.View view, Context context) {
        this.views = view;
        this.context=context;
        initPresenter();
    }
    private void initPresenter() {
        model = new countryModel();
    }
    @Override
    public void getData() {
        ArrayList<countryModel> mylist=null;
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
