package com.hbk.examples.ChainOfResponsibilityDemo.demo_2.middleware;

public class RoleCheckMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if(email.equals("admin@examples.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
