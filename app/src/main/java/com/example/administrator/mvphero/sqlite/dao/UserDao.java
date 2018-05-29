package com.example.administrator.mvphero.sqlite.dao;

import android.content.Context;

import com.example.administrator.mvphero.sqlite.DataBaseHandler;
import com.example.administrator.mvphero.sqlite.bean.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;

public class UserDao {
    private Dao<User, String> userDao;

    private DataBaseHandler dataBaseHandler;

    public UserDao(Context context){
        getDao(context);
    }

    private void getDao(Context context){
        dataBaseHandler = DataBaseHandler.getDBHandler(context);
        try {
            userDao = dataBaseHandler.getUserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user){
        try {
            userDao.createIfNotExists(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id){
        DeleteBuilder<User, String> builder = userDao.deleteBuilder();
        try {
            builder.where().eq("id", id);
            builder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User query(String id){
        QueryBuilder<User, String> builder = userDao.queryBuilder();
        User user = null;
        try {
            builder.where().eq("id", id);
            user = builder.query().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
