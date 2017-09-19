package com.fx.util;

import java.io.BufferedReader;
import java.io.IOException;

public class StringIOUtil {

    public static String readRequest(BufferedReader br) throws IOException {
        String str;
        StringBuilder wholeStr = new StringBuilder();
        while ((str = br.readLine()) != null) {
            wholeStr.append(str);
        }
        return wholeStr.toString();
    }
}
