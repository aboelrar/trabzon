package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.View.Activity.Login;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.interfacee.signupMvp;
import com.example.begroup_web_0.trabzon.library.library;

import org.json.JSONException;
import org.json.JSONObject;

public class signupModel implements signupMvp.interfaces.Model {
    library library;
    @Override
    public String getdata(String mail, String password, String fullName, String phoneNum, String rePass, final Context context) {
        library=new library();
        String signupUrl="http://coderg.org/samaapi/User/registration/samaapi/33154194/"+fullName+"/"+phoneNum+"/"+mail+"/"+password+"/"+rePass;
        StringRequest signupRequest=new StringRequest(Request.Method.GET, signupUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if(jsonObject.getString("status").equals("1"))
                    {
                        library.progressDialog(context);
                        Toast.makeText(context, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context,Login.class));
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
        requestQueue.add(signupRequest);
        return null;
    }
}
