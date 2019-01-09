package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;

public interface signupMvp {

    public interface interfaces {
        interface  View
        {
        }

        interface Model{
            String getdata(String mail, String password,String fullName,String  phoneNum,String rePass,Context context);
        }

        interface presenter{
            void getData();
        }
    }
}
