package com.derbysoft.gps.data;

import java.util.HashMap;
import java.util.Map;

public class TestStr {
    private Map<String, Character> map = new HashMap<>();

    public TestStr() {
        map.put("11", '1');
        map.put("12", '3');
        map.put("13", '2');
        map.put("21", '3');
        map.put("23", '1');
        map.put("22", '2');
        map.put("31", '2');
        map.put("32", '1');
        map.put("33", '3');
    }

    public String translate(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length ; j++) {
                char first = chars[j-1];
                char next = chars[j];
                chars[j-1] = map.get(new String(new char[]{first, next}));
            }


        }
        return String.valueOf(chars[0]);
    }

}
