package com.eyup.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eyup.crud.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
