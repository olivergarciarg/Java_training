package com.oliver;

public class Main {
    public static void main(String[] args) {
        String privateVar = "this is private to main";

        ScopeCheck scopeInstance = new ScopeCheck();
        System.out.println("scopeInstance privateVar " + scopeInstance.getPrivateVar());
        System.out.println(privateVar);
    }
}