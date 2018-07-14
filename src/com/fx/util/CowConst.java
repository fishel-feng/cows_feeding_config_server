package com.fx.util;

import com.fx.entity.Param;

import java.util.HashMap;
import java.util.Map;

public interface CowConst {
    Map<Double, Param> COW_MAP = new HashMap<Double, Param>() {{
        put(350.0, new Param(9.17, 243));
        put(400.0, new Param(10.13, 268));
        put(450.0, new Param(11.07, 293));
        put(500.0, new Param(11.97, 317));
        put(550.0, new Param(12.88, 341));
        put(600.0, new Param(13.73, 364));
        put(650.0, new Param(14.59, 386));
        put(700.0, new Param(15.43, 408));
        put(750.0, new Param(16.24, 430));
    }};
    Map<Double, Param> MILK_MAP = new HashMap<Double, Param>() {{
        put(2.5, new Param(0.80, 49));
        put(3.0, new Param(0.87, 51));
        put(3.5, new Param(0.93, 53));
        put(4.0, new Param(1.00, 55));
        put(4.5, new Param(1.06, 57));
        put(5.0, new Param(1.13, 59));
        put(5.5, new Param(1.19, 61));
    }};
}
