package com.example.begroup_web_0.trabzon.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.begroup_web_0.trabzon.Presenter.loginPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.View.Home;
import com.example.begroup_web_0.trabzon.interfacee.LoginMvp;
import com.example.begroup_web_0.trabzon.library.library;

public class Login extends AppCompatActivity implements LoginMvp.interfaces.View {
  Button send;
  TextView signup;
  EditText mail,password;
    loginPresenter loginPresenter;
    library library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup=(TextView)findViewById(R.id.signup);
        send=(Button)findViewById(R.id.send);
        mail=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        onClick();
        ifLogin();
        }


        public void onClick()
    {
        library=new library();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                library.progressDialog(Login.this);
                startActivity(new Intent(Login.this,signup.class));
                }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mail.getText().toString();
                String Password=password.getText().toString();
                loginPresenter=new loginPresenter(Login.this,Login.this,Password,email);
                loginPresenter.getData();
                }
        });
    }

      public void ifLogin() {
        library library = new library();
        if (library.getUserBoolean(Login.this) == true) {
            startActivity(new Intent(Login.this, Home.class));
        }
    }

}
