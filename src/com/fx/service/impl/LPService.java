package com.fx.service.impl;

import UseLinearProgram.Class1;
import com.fx.entity.request.Cow;
import com.fx.entity.request.Fodder;
import com.fx.entity.request.Request;
import com.fx.entity.response.Response;
import com.fx.service.CalculateService;
import com.fx.util.CowConst;
import com.mathworks.toolbox.javabuilder.MWException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LPService implements CalculateService {
    @Override
    public Response calculate(Request result) throws MWException {
        List<Fodder> fodder = result.fodderList;
        System.out.println(System.getenv("DYLD_LIBRARY_PATH"));
        System.getProperties().list(System.out);
        Fodder[] fodders = new Fodder[fodder.size()];
        fodder.toArray(fodders);
        Arrays.sort(fodders, new Comparator<Fodder>() {
            @Override
            public int compare(Fodder o1, Fodder o2) {
                return Integer.parseInt(o1.type) - Integer.parseInt(o2.type);
            }
        });
        Cow cow = result.cow;
        int coarse = Integer.parseInt(result.coarse);
        int concentrate = Integer.parseInt(result.concentrate);
        double[] prices = new double[fodders.length];
        double[][] params = new double[fodders.length][9];
        double[] crudeFat = new double[fodders.length];
        double[] aeq = new double[fodders.length];
        for (int i = 0; i < fodders.length; i++) {
            Fodder f = fodders[i];
            prices[i] = Double.parseDouble(f.price);
            params[i] = new double[]{Double.parseDouble(f.crudeProtein), Double.parseDouble(f.energy), Double.parseDouble(f.calcium), Double.parseDouble(f.phosphorus), Double.parseDouble(f.sodium), Double.parseDouble(f.chlorine), Double.parseDouble(f.potassium), Double.parseDouble(f.magnesium), Double.parseDouble(f.sulphur)};
            crudeFat[i] = Double.parseDouble(f.crudeFat);
            aeq[i] = Double.parseDouble(f.dryMatter);
        }
        double energy = (CowConst.COW_MAP.get(new Double(cow.weight)).energy + CowConst.MILK_MAP.get(new Double(cow.milkFat)).energy) * 750 / 1000;
        double crudeProtein = (CowConst.COW_MAP.get(new Double(cow.weight)).energy + CowConst.MILK_MAP.get(new Double(cow.milkFat)).energy) / 1000;
        Class1 class1 = new Class1();
        Object[] res = class1.UseLinearProgram(2, prices, coarse + concentrate, concentrate, params, crudeFat, aeq, Double.parseDouble(cow.milkProduction), Double.parseDouble(cow.milkFat), Double.parseDouble(cow.weight), Double.parseDouble(cow.milkWeek), energy, crudeProtein);
        System.out.println(res.length);
        Response response = new Response();
        response.code = "20";
        return response;
    }
}
