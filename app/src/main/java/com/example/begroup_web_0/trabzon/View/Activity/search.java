package com.example.begroup_web_0.trabzon.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Presenter.searchPresenter;
import com.example.begroup_web_0.trabzon.Presenter.tourismPlacePresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.customAdapter.searchAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.tourismPlaceMvp;

import java.util.ArrayList;

public class search extends AppCompatActivity implements tourismPlaceMvp.interfaces.View {

    RecyclerView searchList;
    tourismPlacePresenter  tourismPlacePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_result);
        searchList=(RecyclerView)findViewById(R.id.searchlist);
        tourismPlacePresenter=new tourismPlacePresenter(search.this,search.this,searchList,"");
        tourismPlacePresenter.getData();
    }

}
