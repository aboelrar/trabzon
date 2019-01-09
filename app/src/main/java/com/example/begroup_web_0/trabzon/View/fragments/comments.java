package com.example.begroup_web_0.trabzon.View.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.begroup_web_0.trabzon.Presenter.commentPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.Login;
import com.example.begroup_web_0.trabzon.customAdapter.commentAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.commentsMvp;
import com.example.begroup_web_0.trabzon.library.adapter;
import com.example.begroup_web_0.trabzon.library.library;
import com.example.begroup_web_0.trabzon.list.commentList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class comments extends Fragment implements commentsMvp.interfaces.View {
RecyclerView commentsList;
RecyclerView.Adapter commentsAdapter;
RecyclerView.LayoutManager layoutManager;
View view;
TextView name;

EditText Comment;
    ImageView send;
    RecyclerView addCommentNow;
    commentPresenter commentPresenter;
    library library;
    public comments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_comments, container, false);
        commentsList=(RecyclerView)view.findViewById(R.id.commentList);
        Comment=(EditText)view.findViewById(R.id.addComment);
        commentPresenter=new commentPresenter(comments.this,getActivity(),commentsList,"ahmed mohamed",Comment.getText().toString(),getid());
        commentPresenter.getData();
        onClick();
        return view;
    }


    public void onClick()
    {
        library=new library();

                send=(ImageView)view.findViewById(R.id.send);
        addCommentNow =(RecyclerView)view.findViewById(R.id.commentnowList);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(library.getUserBoolean(getActivity())==false)
                {
                    startActivity(new Intent(getActivity(),Login.class));
                    Toast.makeText(getActivity(), "يجب التسجيل اولا", Toast.LENGTH_SHORT).show();
                }else{
                Comment=(EditText)view.findViewById(R.id.addComment);
                commentPresenter.getData();
                String addComment=Comment.getText().toString();
                commentPresenter=new commentPresenter(comments.this,getActivity(),commentsList,"ahmed mohamed",Comment.getText().toString(),getid());
                commentPresenter.getCommentData();
                addCommentNow();
                adapter adapter=new adapter();
                adapter.adapters(addCommentNow,new commentAdapter(getActivity(),addCommentNow()),getActivity(),addCommentNow());
                }}
        });

    }

    public ArrayList addCommentNow()
    {
        final ArrayList<commentList>arrayList=new ArrayList<commentList>();
        Comment=(EditText)view.findViewById(R.id.addComment);
        arrayList.add(new commentList(1, "aaa", Comment.getText().toString()));
        return arrayList;

    }

    public String getid()
    {
        String id = getArguments().getString("id");
        return id;
    }
}
