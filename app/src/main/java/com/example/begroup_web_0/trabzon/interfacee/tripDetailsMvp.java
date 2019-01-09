package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public interface tripDetailsMvp {
    public interface interfaces {
        interface  View
        {
        }

        interface Model{
            ArrayList getdata(final ViewPager ViewPager, final Context context, final CircleIndicator circleIndicator,String id);
            String getSecondData(final TextView name, final TextView description, final Context context, String id);
        }

        interface presenter{
            void getData();
            void getSecondData();
        }
    }
}
