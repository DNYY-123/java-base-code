package com.student;

public class accountInformation {
    private String userName;
    private String passWord;

    private String id;

    private String phoneNum;


    public accountInformation() {
    }

    public accountInformation(String userName, String passWord, String id, String phoneNum) {
        this.userName = userName;
        this.passWord = passWord;
        this.id = id;
        this.phoneNum = phoneNum;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
