package com.oliver;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("java", "java lang");
        languages.put("python", "python lang");
        languages.put("algol", "algol lang");
        System.out.println(languages.put("basic", "basic lang"));
        System.out.println(languages.put("lisp", "Lisp lang"));

        if (languages.containsKey("java")) {
            System.out.println("java is in map");
        } else {
            languages.put("java", "java course");
        }
        System.out.println("===========================");

        languages.remove("lisp");
        if (languages.remove("algol", "algol langx")) {
            System.out.println("algol removed");
        } else {
            System.out.println("algol not removed");
        }

        System.out.println(languages.replace("python", "python language"));
        for (String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
