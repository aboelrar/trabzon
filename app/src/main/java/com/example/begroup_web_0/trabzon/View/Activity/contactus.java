package com.example.begroup_web_0.trabzon.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.begroup_web_0.trabzon.Presenter.contactUsPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.interfacee.contactUsMvp;

public class contactus extends AppCompatActivity implements contactUsMvp.View{
    EditText fullName,email,phone,message;
    Button send;
    contactUsPresenter contactUsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        fullName=(EditText)findViewById(R.id.fullname);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.mobile);
        message=(EditText)findViewById(R.id.textmsg);
        send=(Button)findViewById(R.id.send);
        onClick();
    }

    public void onClick()
    {
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName=fullName.getText().toString();
                String Email=email.getText().toString();
                String Phone=phone.getText().toString();
                String Message=message.getText().toString();
                contactUsPresenter=new contactUsPresenter(contactus.this,contactus.this,FullName,Email,Phone,Message);
                contactUsPresenter.getData();
            }
        });
    }
}
