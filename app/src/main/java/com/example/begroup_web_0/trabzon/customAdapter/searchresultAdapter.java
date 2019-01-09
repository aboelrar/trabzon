package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.tripDetails;
import com.example.begroup_web_0.trabzon.list.searchResultList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class searchresultAdapter extends RecyclerView.Adapter<searchresultAdapter.searchResultHolder > {
    ArrayList<searchResultList>mylist;
    Context context;
    int resource;

    public searchresultAdapter(ArrayList<searchResultList> mylist, Context context,int resource) {
        this.mylist = mylist;
        this.context = context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public searchResultHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(resource,viewGroup,false);
        searchResultHolder searchResultHolder=new searchResultHolder(view);
        return searchResultHolder;
    }

    @Override
    public void onBindViewHolder(final searchResultHolder viewHolder, final int i) {
        Picasso.with(context).load(mylist.get(i).getSamaimg()).into(viewHolder.tripImg);
        viewHolder.tripName.setText(mylist.get(i).getTripTitle().toString());
        viewHolder.tripDescription.setText(mylist.get(i).getTripDescription().toString());
        viewHolder.value.setText(""+mylist.get(i).getValue());
        viewHolder.ratingBar.setRating((float) mylist.get(i).getValue());
        viewHolder.trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent intent=new Intent(context,tripDetails.class);
                String passingdata = viewHolder.tripName.getText().toString();
                String passingdetails = viewHolder.tripDescription.getText().toString();
                int id=mylist.get(i).getId();
                b.putString("id", String.valueOf(id));
                intent.putExtras(b);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class searchResultHolder extends RecyclerView.ViewHolder {
        ImageView tripImg;
        TextView tripName,tripDescription,value,peopleNum;
        RatingBar ratingBar;
        LinearLayout trips;
        public searchResultHolder(@NonNull View itemView) {
            super(itemView);
            tripImg=(ImageView)itemView.findViewById(R.id.tripimg);
            tripName=(TextView)itemView.findViewById(R.id.tripname);
            tripDescription=(TextView)itemView.findViewById(R.id.tripdescripition);
            value=(TextView)itemView.findViewById(R.id.value);
            peopleNum=(TextView)itemView.findViewById(R.id.peoplenum);
            ratingBar=(RatingBar)itemView.findViewById(R.id.ratings);
            trips=(LinearLayout)itemView.findViewById(R.id.trips);
        }
    }
}
