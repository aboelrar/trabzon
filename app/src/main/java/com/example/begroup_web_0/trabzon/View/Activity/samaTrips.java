package com.example.begroup_web_0.trabzon.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Presenter.samaTripsPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.customAdapter.samaTripsAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;

import java.util.ArrayList;

public class samaTrips extends AppCompatActivity implements MVP.interfaces.View {
    RecyclerView samtriplist;
    RecyclerView.Adapter samaTripAdapter;
    RecyclerView.LayoutManager layoutManager;
    samaTripsPresenter samaTripsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sama_trips);
        samaTripsPresenter=new samaTripsPresenter(this,this);
        samaTripsPresenter.getData();
    }

    public void setviewdata(ArrayList data) {
        layoutManager=new LinearLayoutManager(this);
        samtriplist.setLayoutManager(layoutManager);
        samaTripAdapter=new samaTripsAdapter(this,data);
        samtriplist.setAdapter(samaTripAdapter);
    }
}
