package com.orderhub.entity;

public class User {

    private String userName;
    private String passWord;
    private int userID;

    public User()
    {
    }
    public User(String userName, String passWord, int userID) {
        this.userName = userName;
        this.passWord = passWord;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userID=" + userID +
                '}';
    }
}
