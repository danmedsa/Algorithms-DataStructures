package com.danielmedina;

import java.util.HashMap;

import static java.lang.System.out;

public class HashMapPractice {
    HashMap<String,String> map = new HashMap<>();

    public HashMapPractice() {
        out.println("--- HashMap Generated ---");

    }

    public void populateHashMap() {
        out.println("--- HashMap Populated ---");
        this.map.put("1", "1");
        this.map.put("2", "2");
    }
}
