package com.example.test.data.income;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gold {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private List<List<Integer>> data = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Integer>> getData() {
        return data;
    }

    public void setData(List<List<Integer>> data) {
        this.data = data;
    }

}