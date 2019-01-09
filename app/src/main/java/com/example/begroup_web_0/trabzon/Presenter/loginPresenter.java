package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;

import com.example.begroup_web_0.trabzon.Model.homeModel;
import com.example.begroup_web_0.trabzon.Model.loginModel;
import com.example.begroup_web_0.trabzon.Model.samaTripModel;
import com.example.begroup_web_0.trabzon.interfacee.LoginMvp;
import com.example.begroup_web_0.trabzon.interfacee.MVP;

import java.util.ArrayList;

public class loginPresenter implements LoginMvp.interfaces.presenter {

    private LoginMvp.interfaces.Model model;
    private LoginMvp.interfaces.View views;
    Context context;
    String password,mail;

    public loginPresenter(LoginMvp.interfaces.View view, Context context,String password,String mail) {
        this.views = view;
        this.context=context;
        this.mail=mail;
        this.password=password;
        initPresenter();
    }
    private void initPresenter() {
        model = new loginModel();

    }
    @Override
    public void getData() {
        String data=model.getdata(mail,password,context);
    }
}
