package com.yesilay.stocktrace.dao;


import com.yesilay.stocktrace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Integer > {
     Users findByUserEmail(String userEmail);
}
