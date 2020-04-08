package com.yesilay.stocktrace.service;

import com.yesilay.stocktrace.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.yesilay.stocktrace.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends UserDetailsService {

    Users findByEmail(String email);

    Users save(UserRegistrationDto registration);
}