package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.searchResult;
import com.example.begroup_web_0.trabzon.list.searchList;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class searchAdapter extends RecyclerView.Adapter<searchAdapter.searchHolder>{
    ArrayList<searchList>mylist=new ArrayList<searchList>();
    Context context;

    public searchAdapter(ArrayList<searchList> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public searchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.searchitemright,viewGroup,false);
        searchHolder searchHolder=new searchHolder(view);
        return searchHolder;
    }

    @Override
    public void onBindViewHolder(searchHolder viewHolder, final int i) {
              viewHolder.searchTitle.setText(mylist.get(i).getName().toString());
              viewHolder.search.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      addCategory(String.valueOf(mylist.get(i).getId()));

                      String id= String.valueOf(mylist.get(i).getId());
                      Intent intent=new Intent(context,searchResult.class);
                      v.getContext().startActivity(intent);

                  }
              });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

        public class searchHolder extends RecyclerView.ViewHolder {
        TextView searchTitle;
        LinearLayout search;
        public searchHolder(@NonNull View itemView) {
            super(itemView);
            searchTitle=(TextView)itemView.findViewById(R.id.searchitem);
            search=(LinearLayout)itemView.findViewById(R.id.search);

        }
    }

    public void addCategory(String id)
    {

        SharedPreferences sharedPreferences = context.getSharedPreferences("categoryId", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("categoryId", id);
        editor.commit();
    }
}
