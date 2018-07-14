package com.fx.entity.request;

import com.google.gson.annotations.SerializedName;

public class Cow {

    public String variety;

    public String weight;

    @SerializedName("milk_days")
    public String milkDays;

    @SerializedName("milk_roduction")
    public String milkProduction;

    @SerializedName("milk_week")
    public String milkWeek;

    @SerializedName("milk_fat")
    public String milkFat;
}
