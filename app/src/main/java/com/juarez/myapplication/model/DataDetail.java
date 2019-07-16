package com.juarez.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataDetail {
    @SerializedName("data")
    private Serie data;

    public Serie getSerie() {
        return data;
    }

    public void setSerie(Serie data) {
        this.data = data;
    }
}
