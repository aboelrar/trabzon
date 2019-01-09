package com.example.begroup_web_0.trabzon.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.begroup_web_0.trabzon.Presenter.countryPresenter;
import com.example.begroup_web_0.trabzon.Presenter.searchPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.View.fragments.searchResultGrid;
import com.example.begroup_web_0.trabzon.View.fragments.searchResult_frag;
import com.example.begroup_web_0.trabzon.customAdapter.categoryAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.countryAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.searchAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.searchMvp;

import java.util.ArrayList;

public class searchResult extends AppCompatActivity implements searchMvp.View {

    RecyclerView countryList,tourismPlace;
    RecyclerView.Adapter countryAdapter;
    RecyclerView.LayoutManager layoutManager;
    searchPresenter searchPresenter;
    ImageView gridView,listview;
    ViewSwitcher viewSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        countryList=(RecyclerView)findViewById(R.id.countryList);
        searchPresenter=new searchPresenter(searchResult.this,searchResult.this,countryList);
        gridView=(ImageView)findViewById(R.id.gridview);
        listview=(ImageView)findViewById(R.id.listview);
        viewSwitcher=(ViewSwitcher)findViewById(R.id.viewswitch);
        searchPresenter.getData();
        addFragment();
        onClick();
        }


    public void addFragment()
    {
        Intent intent=getIntent();
        String filter=intent.getStringExtra("name");
        Bundle bundle = new Bundle();
        bundle.putString("name", filter);
        bundle.putString("id", getCategoryId());

// set Fragmentclass Arguments
        onClickImg("1");
        Fragment searchResult = new searchResult_frag();
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.items, searchResult ).commit();
        searchResult.setArguments(bundle);

    }

    public void onClick()
    {
        Intent intent=getIntent();
        String filter=intent.getStringExtra("name");
        final Bundle bundle = new Bundle();
        bundle.putString("name", filter);
        bundle.putString("id", getCategoryId());
        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickImg("0");
                viewSwitcher.showNext();
                Fragment searchResultGrid = new searchResultGrid();
                searchResult.this.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.items, searchResultGrid ).commit();
                searchResultGrid.setArguments(bundle);

            }
        });
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickImg("1");
                viewSwitcher.showNext();
                Intent intent=getIntent();
                String filter=intent.getStringExtra("name");
                final Bundle bundle = new Bundle();
                bundle.putString("name", filter);
                bundle.putString("id", getCategoryId());
                Fragment searchResult = new searchResult_frag();
                searchResult.this.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.items, searchResult ).commit();
                searchResult.setArguments(bundle);

            }
        });
    }

    public String getCategoryId()
    {
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        return id;
    }

    public void onClickImg(String num)
    {

            SharedPreferences sharedPreferences = getSharedPreferences("imgNum", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("imgNum", num);
            editor.commit();

    }
}
