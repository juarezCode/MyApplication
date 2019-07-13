package com.juarez.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    private List<Series> data;


    public List<Series> getSeries() {
        return data;
    }

    public void setSeries(List<Series> series) {
        this.data = series;
    }
}
