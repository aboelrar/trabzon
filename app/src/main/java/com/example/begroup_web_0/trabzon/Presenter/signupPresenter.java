package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;

import com.example.begroup_web_0.trabzon.Model.signupModel;
import com.example.begroup_web_0.trabzon.interfacee.signupMvp;

public class signupPresenter implements signupMvp.interfaces.presenter{
    private signupMvp.interfaces.Model model;
    private signupMvp.interfaces.View views;
    Context context;
    String password,mail,fullname,phome,rePass;

    public signupPresenter(signupMvp.interfaces.View view, Context context,String password,String mail,String fullname,String phome,String rePass) {
        this.views = view;
        this.context=context;
        this.mail=mail;
        this.password=password;
        this.fullname=fullname;
        this.phome=phome;
        this.rePass=rePass;
        initPresenter();
    }
    private void initPresenter() {
        model = new signupModel();
    }
    @Override
    public void getData() {
        String data=model.getdata(mail,password,fullname,phome,rePass,context);
    }
}
