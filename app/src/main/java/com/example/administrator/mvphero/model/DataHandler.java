package com.example.administrator.mvphero.model;

import com.example.administrator.mvphero.sqlite.bean.User;

public interface DataHandler {
    void saveUserData(User user);
    User getLocalUser(String id);
}
