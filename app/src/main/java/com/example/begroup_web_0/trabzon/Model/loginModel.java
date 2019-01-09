package com.example.begroup_web_0.trabzon.Model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.interfacee.LoginMvp;
import com.example.begroup_web_0.trabzon.library.library;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class loginModel implements LoginMvp.interfaces.Model {
    library library;

    @Override
    public String getdata(String mail, String password, final Context context) {
        library = new library();
        String LoginUrl = "http://coderg.org/samaapi/home/do_login/samaapi/33154194/" + mail + "/" + password;
        StringRequest loginRequest = new StringRequest(Request.Method.GET, LoginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("status").equals("1")) {
                        library.progressDialog(context);
                        Toast.makeText(context, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject1=jsonObject.getJSONObject("user_data");
                        String id = jsonObject1.getString("id");
                        id(context,id);
                        context.startActivity(new Intent(context, Home.class));

                    } else if (jsonObject.getString("status").equals("2")) {
                        Toast.makeText(context, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    } else if (jsonObject.getString("status").equals("3")) {
                        Toast.makeText(context, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    Toast.makeText(context, "" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(loginRequest);
        return null;
    }

    public void id(Context context, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("id", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("islogin", true);
        editor.putString("id", id);
        editor.commit();
    }


}