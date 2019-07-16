package com.example.mallmaster.dao;

import com.example.mallmaster.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserDao extends JpaRepository<AdminUser, Integer> {

    AdminUser findByUsernameAndPassword(String username, String pwd);

}
