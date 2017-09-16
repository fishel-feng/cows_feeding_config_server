package com.fx.entity.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    public String code;

    public String price;

    @SerializedName("fodder")
    public List<FodderResult> fodderResults;
}
