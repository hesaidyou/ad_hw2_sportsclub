package com.example.liuyang.sportsclub_fragment;

import cn.bmob.v3.BmobObject;

public class User extends BmobObject{

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
