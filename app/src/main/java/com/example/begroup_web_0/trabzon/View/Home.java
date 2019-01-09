package com.example.begroup_web_0.trabzon.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.begroup_web_0.trabzon.Presenter.homePresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Activity.aboutUs;
import com.example.begroup_web_0.trabzon.View.Activity.contactus;
import com.example.begroup_web_0.trabzon.View.Activity.editData;
import com.example.begroup_web_0.trabzon.View.Activity.live;
import com.example.begroup_web_0.trabzon.View.Activity.questionAndAnswer;
import com.example.begroup_web_0.trabzon.View.Activity.searchResult;
import com.example.begroup_web_0.trabzon.customAdapter.barAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.categoryAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.pagerAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Home extends AppCompatActivity implements MVP.interfaces.View {
    RecyclerView barList,promotelist,nearestList,mostRated;
    RecyclerView.Adapter BarAdapter,categoryAdapter;
    RecyclerView.LayoutManager BarlayoutManager,CategoryLayoutManager;
    homePresenter homePresenter;
    LinearLayout search,gotosamaTrips;
    DrawerLayout drawerLayout;
    ImageView menu;
    TextView promote,nearestPlace,hightrated;
    int count=-2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        menu=(ImageView)findViewById(R.id.menu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        barList=(RecyclerView)findViewById(R.id.barlist);
        promotelist=(RecyclerView)findViewById(R.id.promotelist);
        nearestList=(RecyclerView)findViewById(R.id.nearestlist);
        mostRated=(RecyclerView)findViewById(R.id.mostratedlist);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        homePresenter=new homePresenter(this,this,barList,promotelist,nearestList,mostRated,viewPager,circleIndicator);
        homePresenter.getData();
        homePresenter.getSecondData();
        homePresenter.getThirdData();
        homePresenter.getForthData();
        homePresenter.getFifthData();
        onClick();
        navigation();
        passData();
    }

    public void onClick()
    {
        search=(LinearLayout)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, com.example.begroup_web_0.trabzon.View.Activity.search.class));
            }
        });
        gotosamaTrips=(LinearLayout)findViewById(R.id.gotosamaTrips);
        gotosamaTrips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, com.example.begroup_web_0.trabzon.View.Activity.samaTrips.class));

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);

                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
    }



    public void navigation()
    {
     LinearLayout samaTrips=(LinearLayout)findViewById(R.id.samatrips);
     LinearLayout whoAra=(LinearLayout)findViewById(R.id.whoare);
     LinearLayout questions=(LinearLayout)findViewById(R.id.questions);
     LinearLayout livee=(LinearLayout)findViewById(R.id.live);
     LinearLayout edit=(LinearLayout)findViewById(R.id.edit);
     LinearLayout contactuss=(LinearLayout)findViewById(R.id.contactus);

     samaTrips.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });

        whoAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,aboutUs.class));
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,questionAndAnswer.class));

            }
        });
        livee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,live.class));

            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,editData.class));
            }
        });
        contactuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,contactus.class));

            }
        });
    }
    public void passData()
    {
        promote=(TextView)findViewById(R.id.promote);
        final Intent intent=new Intent(Home.this,searchResult.class);

        promote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name","news");
                startActivity(intent);
            }
        });
        nearestPlace=(TextView)findViewById(R.id.nearest);
        nearestPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name","nearest");
                startActivity(intent);
            }
        });
        hightrated=(TextView)findViewById(R.id.hightrated);
        hightrated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name","hightrate");
                startActivity(intent);
            }
        });
    }

}
