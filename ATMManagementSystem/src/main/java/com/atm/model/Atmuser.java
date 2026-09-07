package com.atm.model;

public class Atmuser {

    private int userId;
    private String username;
    private String pin;
    private String fullName;

    public Atmuser() {
    }

    public Atmuser(int userId, String username,
                String pin, String fullName) {

        this.userId = userId;
        this.username = username;
        this.pin = pin;
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}