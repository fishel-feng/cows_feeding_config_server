package com.fx.entity.request;

import com.google.gson.annotations.SerializedName;

public class Cow {

    public String variety;

    public String weight;

    @SerializedName("weight_change")
    public String weightChange;

    @SerializedName("milk_production")
    public String milkProduction;

    @SerializedName("milk_fat")
    public String milkFat;

    @SerializedName("milk_protein")
    public String milkProtein;

    @SerializedName("lactation_weeks")
    public String lactationWeeks;
}
