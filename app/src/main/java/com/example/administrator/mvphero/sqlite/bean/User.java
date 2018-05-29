package com.example.administrator.mvphero.sqlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_user")
public class User {
    @DatabaseField(id = true)
    private String id;

    @DatabaseField(columnName = "username")
    private String username;

    @DatabaseField(columnName = "password")
    private String password;

    @DatabaseField(columnName = "mobile")
    private long mobile;

    @DatabaseField(columnName = "email")
    private String email;

    @DatabaseField(columnName = "country")
    private String country;

    @DatabaseField(columnName = "province")
    private String province;

    @DatabaseField(columnName = "city")
    private String city;

    @DatabaseField(columnName = "age")
    private int age;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "regtype")
    private int regtype;

    @DatabaseField(columnName = "token")
    private String token;

    @DatabaseField(columnName = "openid")
    private String openid;

    @DatabaseField(columnName = "sex")
    private int sex;

    @DatabaseField(columnName = "headphoto")
    private String headPhoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRegtype() {
        return regtype;
    }

    public void setRegtype(int regtype) {
        this.regtype = regtype;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }
}
