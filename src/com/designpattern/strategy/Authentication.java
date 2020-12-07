package com.designpattern.strategy;

public interface Authentication {
    public void authenticate();
}

class TokenBasedAuthentication implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authentication using Token");
    }
}

class SocialAuthentication implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Authentication using Social");
    }
}

class PasswordBasedAuthentication implements Authentication {
    @Override
    public void authenticate() {
        System.out.println("Basic authentication using username and password");
    }
}