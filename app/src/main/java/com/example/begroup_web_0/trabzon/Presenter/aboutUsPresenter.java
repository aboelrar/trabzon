package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.Model.aboutUsModel;
import com.example.begroup_web_0.trabzon.Model.commentModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.aboutUsMvp;

public class aboutUsPresenter implements aboutUsMvp.presenter{

    private aboutUsMvp.Model model;
    private aboutUsMvp.View views;
    Context context;
    TextView whoTitle,whoDescripition,ourVisionTitle,ourVisionText,overviewTitle,overviewText;

    public aboutUsPresenter(aboutUsMvp.View view, Context context,TextView whoTitle,TextView whoDescripition,TextView ourVisionTitle,TextView ourVisionText,TextView overviewTitle,TextView overviewText) {
        this.views = view;
        this.context=context;
        this.whoTitle=whoTitle;
        this.whoDescripition=whoDescripition;
        this.ourVisionTitle=ourVisionTitle;
        this.ourVisionText=ourVisionText;
        this.overviewTitle=overviewTitle;
        this.overviewText=overviewText;
        initPresenter();
    }
    private void initPresenter() {
        model = new aboutUsModel();
    }

    @Override
    public void getData() {
        String data=model.getdata(whoTitle,whoDescripition,ourVisionTitle,ourVisionText,overviewTitle,overviewText,context);
        }

    @Override
    public void getSecondData() {

    }
}
