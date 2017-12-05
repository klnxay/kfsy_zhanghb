package com.baizhi.common.entity;

public class Man {
    private String id;
    private String username;
    private String password;
    private String salt;

    @Override
    public String toString() {
        return "Man{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Man() {

    }

    public Man(String id, String username, String password, String salt) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
}
