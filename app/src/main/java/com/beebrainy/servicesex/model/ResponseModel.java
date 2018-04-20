package com.beebrainy.servicesex.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Prajwal Gambhir on 19-Apr-18.
 * Copyright (2018) by Cogitate Technology Solution
 */

public class ResponseModel {

    @SerializedName("page")
    int page;
    @SerializedName("per_page")
    int per_page;
    @SerializedName("total")
    int total;

    @SerializedName("total_pages")
    int total_pages;
    @SerializedName("data")
    List<UserModel> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<UserModel> getData() {
        return data;
    }

    public void setData(List<UserModel> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseModel{" + "page=" + page + ", per_page=" + per_page + ", total=" + total
                + ", total_pages=" + total_pages + ", data=" + data + '}';
    }
}

