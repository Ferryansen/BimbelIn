package com.musang.bimbelin.user;

public class DataInfo {
    private String bimbelID;
    private String name;

    public DataInfo() {

    }

    public DataInfo(String bimbelID, String name) {
        this.bimbelID = bimbelID;
        this.name = name;
    }

    public String getBimbelID() {
        return bimbelID;
    }

    public void setBimbelID(String bimbelID) {
        this.bimbelID = bimbelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
