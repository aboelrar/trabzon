package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.searchResult;
import com.example.begroup_web_0.trabzon.View.fragments.searchResultGrid;
import com.example.begroup_web_0.trabzon.View.fragments.searchResult_frag;
import com.example.begroup_web_0.trabzon.library.library;
import com.example.begroup_web_0.trabzon.list.searchList;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class countryAdapter extends RecyclerView.Adapter<countryAdapter.countryHolder> {

    Context context;
    library library;
    ArrayList<searchList>mylist;

    public countryAdapter(Context context, ArrayList<searchList> mylist) {
        this.context = context;
        this.mylist = mylist;

    }

    @NonNull
    @Override
    public countryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.countryitem,viewGroup,false);
        countryHolder countryHolder=new countryHolder(view);
        return countryHolder;
    }

    @Override
    public void onBindViewHolder(final countryHolder viewHolder, final int i) {
        final int id=mylist.get(i).getId();
       viewHolder.title.setText(mylist.get(i).getName().toString());
       viewHolder.country.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               pressFrag(i);
               }
       });

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class countryHolder extends RecyclerView.ViewHolder {
        LinearLayout country;
        TextView title;
        public countryHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            country=(LinearLayout)itemView.findViewById(R.id.country);
        }
    }

    public void addCountry(String id)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("countryId", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("countryId", id);
        editor.commit();
    }

    public void pressFrag(int i)
    {
        library=new library();
        if(library.getImgNum(context).equals("1"))
        {
        addCountry(String.valueOf(mylist.get(i).getId()));
        final Bundle bundle = new Bundle();
        bundle.putString("countryId", String.valueOf(mylist.get(i).getId()));
        Fragment viewSuspendedTransactionFragment = new searchResult_frag();
        FragmentManager manager = ((searchResult) context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.items, viewSuspendedTransactionFragment);
        transaction.commit();
        viewSuspendedTransactionFragment.setArguments(bundle);}
    else {
            addCountry(String.valueOf(mylist.get(i).getId()));
            final Bundle bundle = new Bundle();
            bundle.putString("countryId", String.valueOf(mylist.get(i).getId()));
            Fragment viewSuspendedTransactionFragment = new searchResultGrid();
            FragmentManager manager = ((searchResult) context).getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.items, viewSuspendedTransactionFragment);
            transaction.commit();
            viewSuspendedTransactionFragment.setArguments(bundle);
        }
    }
}
