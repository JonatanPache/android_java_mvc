package com.jonatan.mvc_login.Controller;

import com.jonatan.mvc_login.Model.User;
import com.jonatan.mvc_login.View.ILoginView;

public class LoginController implements ILoginController{

    ILoginView loginView;

    public LoginController( ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValid();
        if ( loginCode == 0 ){
            loginView.OnLoginError("Please enter Email");
        } else if (loginCode == 1) {
            loginView.OnLoginError("Please enter a valid email");
        } else if (loginCode == 2){
            loginView.OnLoginError("Please enter password");
        } else if (loginCode == 3){
            loginView.OnLoginError("Please enter password greater than six char");
        } else {
            loginView.OnLoginSuccess("Login Successful");
        }
    }
}
