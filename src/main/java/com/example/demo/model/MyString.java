package com.example.demo.model;

public class MyString {
    private String myString;
    
    // Add a constructor
    public MyString() {
        this.myString = "";
    }
    
    public void setMyString(String myString) {
        if (myString == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.myString = myString;
    }
    
    public String getMyString() {
        return myString;
    }
}