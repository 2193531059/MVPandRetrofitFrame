package com.example.administrator.mvphero.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.mvphero.sqlite.bean.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DataBaseHandler extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "db_mvpipdvhero";
    private static final int DATABASE_VERSION = 1;

    private static DataBaseHandler instance;

    private Dao<User, String> userDao;

    private DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DataBaseHandler getDBHandler(Context context){
        if (instance == null) {
            synchronized (DataBaseHandler.class) {
                if (instance == null) {
                    instance = new DataBaseHandler(context);
                }
            }
        }
        return instance;
    }

    public Dao<User, String> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }
}
