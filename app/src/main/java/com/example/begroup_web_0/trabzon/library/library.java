package com.example.begroup_web_0.trabzon.library;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class library {

    public void progressDialog(Context context)
    {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Loading...");
        pd.show();
    }

    public String getUserId(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
        String id=sharedPreferences.getString("id","");
        return id;
    }

    public boolean getUserBoolean(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("id",MODE_PRIVATE);
        boolean value=sharedPreferences.getBoolean("islogin",false);
        return value;
    }

    public String getCategoryId(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("categoryId",MODE_PRIVATE);
        String id=sharedPreferences.getString("categoryId","");
        return id;
    }

    public String getCountryId(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("countryId",MODE_PRIVATE);
        String id=sharedPreferences.getString("countryId","");
        return id;
    }

    public String getImgNum(Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences("imgNum",MODE_PRIVATE);
        String id=sharedPreferences.getString("imgNum","");
        return id;
    }
}
