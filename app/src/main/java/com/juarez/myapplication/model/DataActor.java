package com.juarez.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataActor {
    @SerializedName("data")
    List<Actor> data;

    public List<Actor> getActors() {
        return data;
    }

    public void setActors(List<Actor> data) {
        this.data = data;
    }
}
