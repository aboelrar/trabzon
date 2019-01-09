package com.example.begroup_web_0.trabzon.interfacee;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public interface commentsMvp {

    public interface interfaces {
        interface  View
        {

        }

        interface Model{
            ArrayList getdata(RecyclerView recyclerView, Context context,String comment,String id);
            String setData(String name,String comment,Context context,String id);

        }

        interface presenter{
            void getData();
            void getCommentData();
        }
    }

}
