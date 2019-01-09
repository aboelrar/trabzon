package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public interface MVP {
    public interface interfaces {
        interface  View
        {
            }
        interface Model{
            ArrayList getdata(final RecyclerView recyclerView, final Context context);
            ArrayList getSeconddata(final RecyclerView recyclerView, final Context context);
            ArrayList getThirddata(final RecyclerView recyclerView, final Context context);
            ArrayList getFourthdata(final RecyclerView recyclerView, final Context context);
            ArrayList getFifthdata(final ViewPager ViewPager, final Context context,CircleIndicator circleIndicator );


        }
        interface presenter{
            void getData();
            void getSecondData();
            void getThirdData();
            void getForthData();
            void getFifthData();

        }

    }
}
