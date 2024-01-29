package org.example.be.controllers;

import io.restassured.http.Method;
import org.example.be.models.User;
import org.example.core.ApiClient;

public class UserController {

    private static final String GET_USER_DATA = "user";

    public User executeGetUserData() {
        return new ApiClient().build().sendRequest(Method.GET, 200, GET_USER_DATA).as(User.class);
    }

}
