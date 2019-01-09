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
import com.example.begroup_web_0.trabzon.customAdapter.questionAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.searchAdapter;
import com.example.begroup_web_0.trabzon.interfacee.questionMvp;
import com.example.begroup_web_0.trabzon.library.adapter;
import com.example.begroup_web_0.trabzon.list.questionList;
import com.example.begroup_web_0.trabzon.list.searchList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class questionModel implements questionMvp.interfaces.Model {
    @Override
    public ArrayList getdata(final RecyclerView recyclerView, final Context context) {
         final ArrayList<questionList>arrayList=new ArrayList<questionList>();
        String question="http://coderg.org/samaapi/Question/View/samaapi/33154194/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, question, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1"))
                    {
                        JSONArray jsonArray=response.getJSONArray("question");
                        for (int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.getJSONObject(index);
                            arrayList.add(new questionList(jsonObject.getInt("id"),jsonObject.getString("questionTitle"),jsonObject.getString("answer")));
                        }
                        adapter adapter=new adapter();
                        adapter.adapters(recyclerView,new questionAdapter(context,arrayList),context,arrayList);
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

