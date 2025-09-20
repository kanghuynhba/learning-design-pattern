package com.hbk.examples.ChainOfResponsibilityDemo.demo_2.server;

import com.hbk.examples.ChainOfResponsibilityDemo.demo_2.middleware.Middleware;

import java.util.Map;
import java.util.HashMap;

// Server class.
public class Server {
    private Map<String, String> user=new HashMap<>();
    private Middleware middleware;

    // Client passes the chain of object to server.
    // This improves flexibility and makes testing the server classes easier.
    public void setMiddleware(Middleware middleware) {
        this.middleware=middleware;
    }

    // Server gets email and password from client
    // and sends the authorization request to the chain.
    public boolean logIn(String email, String password) {
        if(middleware.check(email, password)) {
            System.out.println("Authorization has been successful!");
            return true; 
        }
        return false;
    }

    public void register(String email, String password) {
        user.put(email, password);
    }

    public boolean hasEmail(String email) {
        return user.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return user.get(email).equals(password);
    }
}
