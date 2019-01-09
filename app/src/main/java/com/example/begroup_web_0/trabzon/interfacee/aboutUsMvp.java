package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public interface aboutUsMvp {

    interface  View
    {

    }

    interface Model{
        String getdata(TextView whoTitle,TextView whoText,TextView outVisionTitle,TextView ourVisionText,TextView overviewTitle,TextView overViewText,Context context);
    }

    interface presenter{

        void getData();
        void getSecondData();

    }
}
