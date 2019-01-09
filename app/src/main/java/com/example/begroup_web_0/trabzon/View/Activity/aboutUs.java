package com.example.begroup_web_0.trabzon.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.Presenter.aboutUsPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.interfacee.aboutUsMvp;

public class aboutUs extends AppCompatActivity implements aboutUsMvp.View {

    aboutUsPresenter aboutUsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getData();
    }

    public void getData()
    {
        TextView whoTitle=(TextView)findViewById(R.id.whoTitle);
        TextView whoText=(TextView)findViewById(R.id.whoText);
        TextView ourVisionTitle=(TextView)findViewById(R.id.ourVisionTitle);
        TextView ourVisionText=(TextView)findViewById(R.id.ourVisionText);
        TextView overviewTitle=(TextView)findViewById(R.id.overviewTitle);
        TextView overviewText=(TextView)findViewById(R.id.overviewText);
        aboutUsPresenter=new aboutUsPresenter(aboutUs.this,aboutUs.this,whoTitle,whoText,ourVisionTitle,ourVisionText,overviewTitle,overviewText);
        aboutUsPresenter.getData();
    }
}
