package com.example.begroup_web_0.trabzon.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.begroup_web_0.trabzon.Presenter.signupPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.interfacee.signupMvp;

public class signup extends AppCompatActivity implements signupMvp.interfaces.View{
  Button send;
  TextView login;
  EditText fullName,email,phone,pass,rePass;
    signupPresenter signupPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        send=(Button)findViewById(R.id.send);
        login=(TextView) findViewById(R.id.login);
        fullName=(EditText)findViewById(R.id.fullname);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.mobile);
        pass=(EditText)findViewById(R.id.password);
        rePass=(EditText)findViewById(R.id.repasswprd);
        onClick();
    }

    public void onClick()
    {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullNameTexte=fullName.getText().toString();
                String Email=email.getText().toString();
                String Phone=phone.getText().toString();
                String password=pass.getText().toString();
                String rePassword=rePass.getText().toString();
                signupPresenter=new signupPresenter(signup.this,signup.this,password,Email,fullNameTexte,Phone,rePassword);
                signupPresenter.getData();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,Login.class));
                }
        });
    }
}
