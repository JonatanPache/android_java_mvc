package com.jonatan.mvc_login.Model;

public interface IUser {

    String getEmail();
    String getPassword();
    int isValid();
}
