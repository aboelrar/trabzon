package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.searchResult;
import com.example.begroup_web_0.trabzon.list.barList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class barAdapter extends RecyclerView.Adapter<barAdapter.barHolder> {

    Context context;
    ArrayList<barList>mylist;

    public barAdapter(Context context, ArrayList<barList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public barHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.baritem,viewGroup,false);
        barHolder barHolder=new barHolder(view);
        return barHolder;
    }

    @Override
    public void onBindViewHolder(barHolder viewHolder,final int i) {
       viewHolder.barName.setText(mylist.get(i).getName().toString());
       Picasso.with(context).load(mylist.get(i).getImg()).into(viewHolder.barIcon);
        viewHolder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,searchResult.class);
                intent.putExtra("id",String.valueOf(mylist.get(i).getId()));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class barHolder extends RecyclerView.ViewHolder {
        ImageView barIcon;
        TextView barName;
        LinearLayout list_item;
        public barHolder(@NonNull View itemView) {
            super(itemView);
            barIcon=(ImageView)itemView.findViewById(R.id.baricon);
            barName=(TextView)itemView.findViewById(R.id.barname);
            list_item=(LinearLayout)itemView.findViewById(R.id.list_item);
        }
    }
}
