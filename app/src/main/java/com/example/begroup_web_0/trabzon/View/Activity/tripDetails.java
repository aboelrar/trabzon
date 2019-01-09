package com.example.begroup_web_0.trabzon.View.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.Presenter.tripDetailsPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.View.fragments.comments;
import com.example.begroup_web_0.trabzon.View.fragments.detailsFragments;
import com.example.begroup_web_0.trabzon.View.fragments.mapsforitem;
import com.example.begroup_web_0.trabzon.customAdapter.pagerAdapter;
import com.example.begroup_web_0.trabzon.interfacee.tripDetailsMvp;

import me.relex.circleindicator.CircleIndicator;

public class tripDetails extends AppCompatActivity implements tripDetailsMvp.interfaces.View {
    int count=-2;
    TabLayout tab;
   ImageView barimg;
    tripDetailsPresenter tripDetailsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);
        tab = (TabLayout) findViewById(R.id.bottomnav);
        barimg=(ImageView)findViewById(R.id.barimg);
        TextView tripname = (TextView) findViewById(R.id.name);
        TextView details = (TextView) findViewById(R.id.details);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        tripDetailsPresenter=new tripDetailsPresenter(this,this,tripname,details,tripId(),viewPager,circleIndicator);
        tripDetailsPresenter.getData();
        tripDetailsPresenter.getSecondData();
        tab1();
        commets();
        onClick();
        tripId();
        navigation();
    }


    public void tab1() {
        tab.addTab(tab.newTab().setText("التعليقات"));
        tab.addTab(tab.newTab().setText("الخريطه"));
        tab.addTab(tab.newTab().setText("اوقات العمل"));
        tab.addTab(tab.newTab().setText("عنوان المكان"));
        tab.addTab(tab.newTab().setText("جهات الاتصال"));

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    commets();
                } else if (position == 1) {
                    Intent intent = new Intent(tripDetails.this, mapsforitem.class);
                    startActivity(intent);

                } else if (position == 2) {
                    fragment();
                }else if(position == 3)
                {
                    fragment();

                }else if(position == 4)
                {
                    fragment();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                }
        });
    }

            public void fragment()
            {
                Fragment detailsFragments = new detailsFragments();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.items, detailsFragments).commit();
            }

    public void commets()
    {
        Bundle bundle = new Bundle();
        bundle.putString("id",tripId());
// set Fragmentclass Arguments
        Fragment comments = new comments();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.items, comments).commit();
        comments.setArguments(bundle);

    }

   public void onClick()
   {
       barimg.setImageResource(R.drawable.ic_menu_black_24dp);
       final DrawerLayout  drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
       barimg.setOnClickListener(new View.OnClickListener() {
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

    public String tripId() {

        Bundle b = getIntent().getExtras();
        final String id = b.getString("id");
       return id;
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
                startActivity(new Intent(tripDetails.this,aboutUs.class));
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tripDetails.this,questionAndAnswer.class));

            }
        });
        livee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tripDetails.this,live.class));

            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tripDetails.this,editData.class));
            }
        });
        contactuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tripDetails.this,contactus.class));

            }
        });
    }


}
