package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;

import com.example.begroup_web_0.trabzon.Model.contactUsModel;
import com.example.begroup_web_0.trabzon.Model.loginModel;
import com.example.begroup_web_0.trabzon.interfacee.contactUsMvp;
import com.example.begroup_web_0.trabzon.interfacee.signupMvp;

public class contactUsPresenter implements contactUsMvp.presenter{

    private contactUsMvp.Model model;
    private contactUsMvp.View views;
    Context context;
    String fullName,mail,phone,message;

    public contactUsPresenter(contactUsMvp.View view, Context context,String fullName,String mail,String phone,String message) {
        this.views = view;
        this.context=context;
        this.mail=mail;
        this.fullName=fullName;
        this.phone=phone;
        this.message=message;
        initPresenter();
    }
    private void initPresenter() {
        model = new contactUsModel();

    }
    @Override
    public void getData() {
        String data=model.getdata(mail,fullName,phone,message,context);
    }
}
