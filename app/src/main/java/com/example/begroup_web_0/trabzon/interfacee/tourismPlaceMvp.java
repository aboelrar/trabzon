package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public interface tourismPlaceMvp {

    public interface interfaces {
        interface  View
        {

        }

        interface Model{
            ArrayList getdata(RecyclerView recyclerView, Context context,int resource,String filter,String categoryId,String countryId);
            ArrayList getSeconddata(RecyclerView recyclerView, Context context,int resource,String filter,String categoryId,String countryId);

        }

        interface presenter{
            void getData();
            void getSecondData();
        }
    }
}
