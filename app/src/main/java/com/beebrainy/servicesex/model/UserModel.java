package com.beebrainy.servicesex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Prajwal Gambhir on 19-Apr-18.
 * Copyright (2018) by Cogitate Technology Solution
 */

public class UserModel {

    @SerializedName("id")
    int id;
    @SerializedName("first_name")
    String first_name;
    @SerializedName("last_name")
    String last_name;
    @SerializedName("avatar")
    String avatar;

    public UserModel(int id, String first_name, String last_name, String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", first_name='" + first_name + '\'' + ", last_name='"
                + last_name + '\'' + ", avatar='" + avatar + '\'' + '}';
    }
}
