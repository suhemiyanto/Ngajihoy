package com.example.suhemi.gurungaji;

public class User {
    private String Name;
    private String Jk;
    private String Phone;
    private String UserName;
    private String Password;
    private String Alamat;

    public User() {
    }

    public User(String name, String jk, String phone, String userName, String password, String alamat) {
        Name = name;
        Jk = jk;
        Phone = phone;
        UserName = userName;
        Password = password;
        Alamat = alamat;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJk() {
        return Jk;
    }

    public void setJk(String jk) {
        Jk = jk;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }
}
 