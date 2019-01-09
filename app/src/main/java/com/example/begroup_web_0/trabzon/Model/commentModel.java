package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.customAdapter.commentAdapter;
import com.example.begroup_web_0.trabzon.interfacee.commentsMvp;
import com.example.begroup_web_0.trabzon.library.adapter;
import com.example.begroup_web_0.trabzon.library.library;
import com.example.begroup_web_0.trabzon.list.commentList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class commentModel implements commentsMvp.interfaces.Model {
     ArrayList<commentList>arrayList=new ArrayList<commentList>();
    adapter adapter=new adapter();
    @Override
    public ArrayList getdata(final RecyclerView recyclerView, final Context context,String comment,String id) {

         String commentsUrl="http://coderg.org/samaapi/TourismPlace/TourismPlaceComments/samaapi/33154194/"+id+"/1";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, commentsUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if(response.getString("status").equals("1")) {
                        JSONArray jsonArray = response.getJSONArray("commentDetails");
                        for(int index=0;index<jsonArray.length();index++)
                        {
                            JSONObject jsonObject=jsonArray.optJSONObject(index);
                            arrayList.add(new commentList(jsonObject.getInt("userId"),jsonObject.getString("userName"),jsonObject.getString("UserCommnet")));
                            }


                    adapter.adapters(recyclerView,new commentAdapter(context,arrayList),context,arrayList);
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
                Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
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
    public String setData(String name, final String comment, final Context context,String id) {

        library library=new library();
        String addCommentUrl="http://coderg.org/samaapi/TourismPlace/add_comment/samaapi/33154194/"+library.getUserId(context)+"/"+id+"/"+comment;
        StringRequest stringRequest=new StringRequest(Request.Method.GET, addCommentUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(response);
                    if(jsonObject.getString("status").equals("1"))
                    {
                        Toast.makeText(context, "تمت الاضافه بنجاح", Toast.LENGTH_SHORT).show();
                    }
                    else if(jsonObject.getString("status").equals("2"))
                    {
                        Toast.makeText(context, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                    else if(jsonObject.getString("status").equals("3"))
                    {
                        Toast.makeText(context, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "no Connection", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return null;
    }
}