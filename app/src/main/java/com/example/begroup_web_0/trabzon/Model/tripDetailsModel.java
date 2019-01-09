package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.customAdapter.pagerAdapter;
import com.example.begroup_web_0.trabzon.interfacee.tripDetailsMvp;
import com.example.begroup_web_0.trabzon.list.sliderList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class tripDetailsModel implements tripDetailsMvp.interfaces.Model {
    int count=-2;


    @Override
    public ArrayList getdata(final ViewPager ViewPager, final Context context, final CircleIndicator circleIndicator,String id) {
        final ArrayList<sliderList>arrayList=new ArrayList<sliderList>();
        String sliderUrl="http://coderg.org/samaapi/TourismPlace/View/samaapi/33154194/";
        JsonObjectRequest  jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, sliderUrl+id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("PlaceImages");
                        for(int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new sliderList(jsonObject.getString("Images")));
                        }
                        pagerAdapter viewimage = new pagerAdapter(context, arrayList);
                        ViewPager.setAdapter(viewimage);
                        circleIndicator.setViewPager(ViewPager);
                        final Handler handler = new Handler();
                        final Runnable runnable = new Runnable() {
                            public void run() {

                                if (count++ <3){
                                    ViewPager.setCurrentItem(count+ 1);
                                }
                                else if(count-->0){
                                    ViewPager.setCurrentItem(count-1);

                                }
                                handler.postDelayed(this, 5000);

                            }
                        };

                        // trigger first time
                        handler.post(runnable);
                    }
                    else if(response.getString("status").equals("2"))
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
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
        return null;

    }

    @Override
    public String getSecondData(final TextView name, final TextView description, final Context context, String id) {
        String tripDetailsUrl="http://coderg.org/samaapi/TourismPlace/View/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, tripDetailsUrl+id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        String tname;
                        String tdescripition;

                        JSONObject jsonObject=response.getJSONObject("placeData");
                        tname=jsonObject.getString("name");
                        tdescripition=jsonObject.getString("description");
                        name.setText(tname);
                        description.setText(tdescripition);

                    }
                    else if(response.getString("status").equals("2"))
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
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(jsonObjectRequest);
        return null;
    }
}
