package com.designpattern.strategy;

public class Context {
    private Authentication authentication;

    public Context(Authentication authentication) {
        this.authentication = authentication;
    }

    public void executeStrategy() {
        authentication.authenticate();
    }
}
