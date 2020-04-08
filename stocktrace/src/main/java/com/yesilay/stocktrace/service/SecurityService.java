package com.yesilay.stocktrace.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}