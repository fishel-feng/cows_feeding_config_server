package com.fx.entity.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Request {

    @SerializedName("fodder")
    public List<Fodder> fodderList;

    public Cow cow;

    public String coarse;

    public String concentrate;
}
