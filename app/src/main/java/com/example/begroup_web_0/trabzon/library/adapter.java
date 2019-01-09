package com.example.begroup_web_0.trabzon.library;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class adapter {


    public void adapters(RecyclerView recyclerView, RecyclerView.Adapter dd, Context context, ArrayList arrayList)
    {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter= dd;
        adapter.notifyItemInserted(0);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


    }

    public void gridAdapters(RecyclerView recyclerView, RecyclerView.Adapter dd, Context context)
    {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter= dd;
        recyclerView.setAdapter(adapter);
    }
    public void griddAdapters(RecyclerView recyclerView, RecyclerView.Adapter dd, Context context)
    {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter= dd;
        recyclerView.setAdapter(adapter);
    }
}
