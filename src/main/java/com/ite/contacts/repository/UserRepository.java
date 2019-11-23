package com.ite.contacts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.contacts.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

}
