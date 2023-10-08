package com.jonatan.mvc_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonatan.mvc_login.Controller.ILoginController;
import com.jonatan.mvc_login.Controller.LoginController;
import com.jonatan.mvc_login.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText email, password;
    Button btn_login;
    ILoginController loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        btn_login = (Button) findViewById(R.id.btn_login);

        loginPresenter = new LoginController(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}