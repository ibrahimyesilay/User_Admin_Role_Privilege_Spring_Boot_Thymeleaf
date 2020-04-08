package com.yesilay.stocktrace.dao;

import com.yesilay.stocktrace.model.Privilege;
import com.yesilay.stocktrace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDao extends JpaRepository<Privilege, Integer > {
    Privilege findByName(String name);
}
