package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;

public interface contactUsMvp {
    interface  View
    {

    }

    interface Model{
        String getdata(String mail, String name,String phone,String message,Context context);
    }

    interface presenter{
        void getData();
    }
}
