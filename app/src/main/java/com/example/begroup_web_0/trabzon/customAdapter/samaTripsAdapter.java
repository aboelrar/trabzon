package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.list.samaTripsList;

import java.util.ArrayList;

public class samaTripsAdapter extends RecyclerView.Adapter<samaTripsAdapter.samaHolder>{

    Context context;
    ArrayList<samaTripsList>mylist;

    public samaTripsAdapter(Context context, ArrayList<samaTripsList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public samaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.tripitem,viewGroup,false);
        samaHolder samaHolder=new samaHolder(view);
        return samaHolder;
    }

    @Override
    public void onBindViewHolder(samaHolder viewHolder, int i) {
        viewHolder.countryName.setText(mylist.get(i).getCountryName().toString());
        viewHolder.tripCode.setText(mylist.get(i).getTripcode().toString());
        viewHolder.history.setText(mylist.get(i).getHistory().toString());
        viewHolder.price.setText(mylist.get(i).getPrice().toString());
        viewHolder.flightHours.setText(mylist.get(i).getFlightHours().toString());
        viewHolder.arrivalHours.setText(mylist.get(i).getArrivalHours().toString());
        viewHolder.flightMin.setText(mylist.get(i).getFlightMin().toString());
        viewHolder.arrivalMin.setText(mylist.get(i).getArrivalMin().toString());

        if(i%2==0){

            viewHolder.linear.setBackgroundColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.book.setBackgroundColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.book.setTextColor(ContextCompat.getColor(context,R.color.color3));


        }else{
            viewHolder.linear.setBackgroundColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.book.setBackgroundColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.book.setTextColor(ContextCompat.getColor(context,R.color.color2));
            viewHolder.countryName.setTextColor(ContextCompat.getColor(context,R.color.color3));
            viewHolder.tripCode.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.history.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.price.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.flightHours.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.arrivalHours.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.flightMin.setTextColor(ContextCompat.getColor(context,R.color.color1));
            viewHolder.arrivalMin.setTextColor(ContextCompat.getColor(context,R.color.color1));
            }
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class samaHolder extends RecyclerView.ViewHolder {
        TextView countryName,tripCode,history,price,flightHours,arrivalHours,flightMin,arrivalMin;
        Button book;
        LinearLayout linear;
        public samaHolder(@NonNull View itemView) {
            super(itemView);
            countryName=(TextView)itemView.findViewById(R.id.countryName);
            tripCode=(TextView)itemView.findViewById(R.id.tripcode);
            history=(TextView)itemView.findViewById(R.id.history);
            price=(TextView)itemView.findViewById(R.id.price);
            flightHours=(TextView)itemView.findViewById(R.id.flight);
            arrivalHours=(TextView)itemView.findViewById(R.id.arrival);
            linear=(LinearLayout)itemView.findViewById(R.id.lineara);
            book=(Button)itemView.findViewById(R.id.book);
            flightMin=(TextView)itemView.findViewById(R.id.flightmin);
            arrivalMin=(TextView)itemView.findViewById(R.id.arrivalmin);
        }
    }
}
