package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.customAdapter.countryAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.searchresultAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.searchMvp;
import com.example.begroup_web_0.trabzon.library.adapter;
import com.example.begroup_web_0.trabzon.list.searchList;
import com.example.begroup_web_0.trabzon.list.searchResultList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class searchModel implements searchMvp.Model {

    @Override
    public ArrayList getdata(final RecyclerView recyclerView, final Context context) {
        String countryUrl="http://coderg.org/samaapi/TourismPlace/getAllCities/samaapi/33154194";
        final ArrayList<searchList>arrayList=new ArrayList<searchList>();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, countryUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1")) {
                        JSONArray jsonArray = response.getJSONArray("AllCitiesData");
                        for(int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new searchList(jsonObject.getInt("id"),jsonObject.getString("name")));
                        }
                        adapter adapter=new adapter();
                        adapter.gridAdapters(recyclerView,new countryAdapter(context,arrayList),context);

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
    public ArrayList getSeconddata(final RecyclerView recyclerView, final Context context) {

        return null;
    }



}
