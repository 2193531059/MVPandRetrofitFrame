package com.example.administrator.mvphero.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.administrator.mvphero.sqlite.bean.User;
import com.example.administrator.mvphero.sqlite.dao.UserDao;
import com.example.administrator.mvphero.util.PreferenceUtil;

/**
 * Created by Administrator on 2018/5/29.
 */

public class DataHandlerImpl implements DataHandler{
    private UserDao mUserDao;
    private Context context;
    private PreferenceUtil preferenceUtil;

    public DataHandlerImpl(Context context) {
        this.context = context;
        preferenceUtil = new PreferenceUtil(context);
    }

    @Override
    public void saveUserData(User user) {
        if (mUserDao == null) {
            mUserDao = new UserDao(context);
        }
        mUserDao.add(user);
        PreferenceUtil util = new PreferenceUtil(context);
        util.setUid(user.getId());
    }

    @Override
    public User getLocalUser(String id) {
        if (mUserDao == null) {
            mUserDao = new UserDao(context);
        }
        String uid = preferenceUtil.getUid();
        User user = null;
        if (!TextUtils.isEmpty(uid)) {
            user = mUserDao.query(id);
        }
        return user;
    }
}
