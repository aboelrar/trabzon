package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public interface LoginMvp  {
    public interface interfaces {
        interface  View
        {

        }

        interface Model{
            String getdata(String mail, String password,Context context);
        }

        interface presenter{
            void getData();
        }

    }
}
