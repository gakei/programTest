package com.entity;

public class User {
    private String name;
    private String psw;
    private int stuId;

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
