package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public interface searchMvp {
    interface  View
    {

    }

    interface Model{

        ArrayList getdata(RecyclerView recyclerView, Context context);
        ArrayList getSeconddata(RecyclerView recyclerView, Context context);

        }

    interface presenter{

        void getData();
        void getSecondData();

        }
}

