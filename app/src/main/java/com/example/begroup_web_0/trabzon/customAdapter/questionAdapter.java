package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.list.questionList;

import java.util.ArrayList;

public class questionAdapter  extends RecyclerView.Adapter<questionAdapter.questionHolder> {
    Context context;
    ArrayList<questionList>mylist;

    public questionAdapter(Context context, ArrayList<questionList> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public questionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.questionitem,viewGroup,false);
        questionHolder questionHolder=new questionHolder(view);
        return questionHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull questionHolder viewHolder, int i) {
            viewHolder.question.setText(mylist.get(i).getQuestion().toString());
            viewHolder.answer.setText(mylist.get(i).getAnswer().toString());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class questionHolder extends RecyclerView.ViewHolder {
        TextView question,answer;
        public questionHolder(@NonNull View itemView) {
            super(itemView);
            question=(TextView)itemView.findViewById(R.id.question);
            answer=(TextView)itemView.findViewById(R.id.answer);
        }
    }
}
