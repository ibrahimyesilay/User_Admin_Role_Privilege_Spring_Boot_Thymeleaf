package com.yesilay.stocktrace.service;

import com.yesilay.stocktrace.dao.RoleDao;
import com.yesilay.stocktrace.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.yesilay.stocktrace.model.Roles;
import com.yesilay.stocktrace.model.Users;
import com.yesilay.stocktrace.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private RoleDao roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users findByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public Users save(UserRegistrationDto registration) {
        Users user = new Users();
       // user.setUserName(registration.getUserName());
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setUserEmail(registration.getUserEmail());
        user.setUserTerms(registration.getUserTerms());
        user.setbDay(registration.getbDay());
        user.setGender(registration.getGender());
        user.setAddress("Null");
        user.setProfilePhoto("Null");
        user.setUserCreated(new Date());
        user.setUserLastLogin(new Date());
        user.setUserActive(true);

        user.setUserPass(passwordEncoder.encode(registration.getUserPass()));

        Roles usersRole = roleRepository.findByRoleName("ROLE_USER");
        user.setRoleList(Arrays.asList(usersRole));

//        user.setRoleList(Arrays.asList(roleRepository.findByRoleName("ROLE_USER")));
//
//        user.setRoleList(Arrays.asList(new Roles("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Users user = userRepository.findByUserEmail(userEmail);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(),
                user.getUserPass(),
                mapRolesToAuthorities(user.getRoleList()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Roles > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }
}