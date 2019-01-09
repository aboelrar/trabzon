package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.interfacee.aboutUsMvp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class aboutUsModel implements aboutUsMvp.Model {
    @Override
    public String getdata(final TextView whoTitle, final TextView whoText, final TextView outVisionTitle, final TextView ourVisionText, final TextView overviewTitle, final TextView overViewText, final Context context) {
        String aboutUsUrl="http://coderg.org/samaapi/Aboutus/sama/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, aboutUsUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("finalDataForSama");
                        for (int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.optJSONObject(index);
                            if(index==0)
                            {
                                whoTitle.setText(jsonObject.getString("title"));
                                whoText.setText(jsonObject.getString("description"));
                            }  else if(index==1)
                        {
                            outVisionTitle.setText(jsonObject.getString("title"));
                            ourVisionText.setText(jsonObject.getString("description"));
                        }
                            if(index==2)
                            {
                                overviewTitle.setText(jsonObject.getString("title"));
                                overViewText.setText(jsonObject.getString("description"));
                            }
                        }
                    }else if(response.getString("status").equals("2"))
                    {
                        Toast.makeText(context, ""+response.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                    else if(response.getString("status").equals("3"))
                    {
                        Toast.makeText(context, ""+response.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();                }

                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
        return null;
    }
}
