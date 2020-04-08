package com.yesilay.stocktrace.component;

import com.yesilay.stocktrace.dao.PrivilegeDao;
import com.yesilay.stocktrace.dao.RoleDao;
import com.yesilay.stocktrace.dao.UserDao;
import com.yesilay.stocktrace.model.Privilege;
import com.yesilay.stocktrace.model.Roles;
import com.yesilay.stocktrace.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserDao userRepository;

    @Autowired
    private RoleDao roleRepository;

    @Autowired
    private PrivilegeDao privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Roles adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
        Users user = new Users();
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setUserPass(passwordEncoder.encode("admin"));
        user.setUserEmail("admin@admin.com");

        user.setRoleList(Arrays.asList(adminRole));
        user.setUserActive(true);
        user.setUserCreated(new Date());
        user.setUserLastLogin(new Date());
        user.setUserTerms(true);

        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Roles createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Roles role = roleRepository.findByRoleName(name);
        if (role == null) {
            role = new Roles(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}