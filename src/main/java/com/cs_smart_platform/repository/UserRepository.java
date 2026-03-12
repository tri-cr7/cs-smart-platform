package com.cs_smart_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs_smart_platform.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
