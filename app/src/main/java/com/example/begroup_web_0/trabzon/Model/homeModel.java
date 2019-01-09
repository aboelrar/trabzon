package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.customAdapter.barAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.categoryAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.pagerAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.searchAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.library.adapter;
import com.example.begroup_web_0.trabzon.list.barList;
import com.example.begroup_web_0.trabzon.list.categoryList;
import com.example.begroup_web_0.trabzon.list.searchList;
import com.example.begroup_web_0.trabzon.list.sliderList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class homeModel implements MVP.interfaces.Model {
    int count=-2;

    @Override
    public ArrayList getdata(final RecyclerView recyclerView, final Context context) {

        final ArrayList<barList>arrayList=new ArrayList<barList>();
        String tourism="http://coderg.org/samaapi/TourismPlace/getTourismPlaceType/samaapi/33154194/1/new/AllCountries";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, tourism, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("tourismPalceTypeData");
                        for (int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new barList(jsonObject.getInt("id"),jsonObject.getString("image"),jsonObject.getString("name")));
                        }
                        adapter adapter=new adapter();
                        adapter.gridAdapters(recyclerView,new barAdapter(context,arrayList),context);
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
    public ArrayList getSeconddata(final RecyclerView recyclerView, final Context context) {
        final ArrayList<categoryList>arrayList=new ArrayList<categoryList>();
        String promotePlaces="http://coderg.org/samaapi/home/getallPaymentPlacesLimitFive/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, promotePlaces, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("placeInfo");
                        for (int index=0;index<3;index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new categoryList(1,jsonObject.getString("image"),jsonObject.getInt("rating"),jsonObject.getString("name")));
                        }
                        adapter adapter=new adapter();
                        adapter.adapters(recyclerView,new categoryAdapter(context,arrayList),context,arrayList);
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
        return arrayList;
    }

    @Override
    public ArrayList getThirddata(final RecyclerView recyclerView, final Context context) {
        final ArrayList<categoryList>arrayList=new ArrayList<categoryList>();
        String nearby="http://coderg.org/samaapi/home/getAllNearbyLimitFive/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, nearby, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("placeInfo");
                        for (int index=0;index<3;index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new categoryList(1,jsonObject.getString("image"),jsonObject.getInt("rating"),jsonObject.getString("name")));
                        }
                        adapter adapter=new adapter();
                        adapter.adapters(recyclerView,new categoryAdapter(context,arrayList),context,arrayList);
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
        return arrayList;
    }

    @Override
    public ArrayList getFourthdata(final RecyclerView recyclerView, final Context context) {
        final ArrayList<categoryList>arrayList=new ArrayList<categoryList>();
        String mostrated="http://coderg.org/samaapi/home/getMostRateLimitFive/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, mostrated, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("placeInfo");
                        for (int index=0;index<3;index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new categoryList(1,jsonObject.getString("image"),jsonObject.getInt("rating"),jsonObject.getString("name")));
                        }
                        adapter adapter=new adapter();
                        adapter.adapters(recyclerView,new categoryAdapter(context,arrayList),context,arrayList);
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
        return arrayList;
    }

    @Override
    public ArrayList getFifthdata(final ViewPager ViewPager, final Context context, final CircleIndicator circleIndicator) {
        final ArrayList<sliderList>arrayList=new ArrayList<sliderList>();
        String sliderUrl="http://coderg.org//samaapi/home/getSliderData/samaapi/33154194/";
        JsonObjectRequest  jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, sliderUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("sliderData");
                        for(int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new sliderList(jsonObject.getString("image")));
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
}
