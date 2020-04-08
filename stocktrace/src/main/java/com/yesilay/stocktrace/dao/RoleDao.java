package com.yesilay.stocktrace.dao;

import com.yesilay.stocktrace.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Roles, Integer> {
    Roles findByRoleName(String role_user);
}
