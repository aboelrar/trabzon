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
import com.example.begroup_web_0.trabzon.list.categoryList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryHolder> {
    Context context;
    ArrayList<categoryList>mylist;
    public categoryAdapter(Context context, ArrayList<categoryList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public categoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.categoryitemright,viewGroup,false);
        categoryHolder categoryHolder=new categoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(final categoryHolder viewHolder, int i) {
        Picasso.with(context).load(mylist.get(i).getImg()).into(viewHolder.catImg);
           viewHolder.Name.setText(mylist.get(i).getName().toString());
           viewHolder.ratingBar.setRating(mylist.get(i).getRatings());

           viewHolder.trip.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Bundle b = new Bundle();
                   Intent intent=new Intent(context,tripDetails.class);

                   b.putString("tripdetails", " تعد من اعظم المعالم السياحيه عبر مر التاريخ");
                   b.putString("tripname", "مدينه الغردقه");
                   intent.putExtras(b);
                   v.getContext().startActivity(intent);

               }
           });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class categoryHolder extends RecyclerView.ViewHolder {
        ImageView catImg;
        TextView Name;
        RatingBar ratingBar;
        LinearLayout trip;

        public categoryHolder(@NonNull View itemView) {
            super(itemView);
            catImg=(ImageView)itemView.findViewById(R.id.catimg);
              Name=(TextView) itemView.findViewById(R.id.placeName);
              ratingBar=(RatingBar)itemView.findViewById(R.id.ratings);
            trip=(LinearLayout)itemView.findViewById(R.id.trip);
        }
    }
}
