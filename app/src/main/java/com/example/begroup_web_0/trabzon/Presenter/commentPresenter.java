package com.example.begroup_web_0.trabzon.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Model.commentModel;
import com.example.begroup_web_0.trabzon.Model.countryModel;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.commentsMvp;

import java.util.ArrayList;

public class commentPresenter implements commentsMvp.interfaces.presenter {
    private commentsMvp.interfaces.Model model;
    private commentsMvp.interfaces.View views;
    RecyclerView recyclerView;
    String name,Comment,id;
    Context context;

    public commentPresenter(commentsMvp.interfaces.View view, Context context, RecyclerView recyclerView,String name,String Comment,String id) {
        this.views = view;
        this.context=context;
        this.recyclerView=recyclerView;
        this.name=name;
        this.Comment=Comment;
        this.id=id;
        initPresenter();
    }
    private void initPresenter() {
        model = new commentModel();
    }

    @Override
    public void getData() {
        ArrayList<commentModel> mylist=model.getdata(recyclerView,context,Comment,id);
    }

    @Override
    public void getCommentData() {
        String list=model.setData(name,Comment,context,id);

    }


}
