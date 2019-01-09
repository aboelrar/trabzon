package com.example.begroup_web_0.trabzon.View.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.VideoView;

import com.example.begroup_web_0.trabzon.R;

public class live extends AppCompatActivity {
 WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        web=(WebView)findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://basturkelektronik.com/flash/player/index.php?stream=uzungol2.stream");
    }
}
