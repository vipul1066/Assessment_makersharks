package com.MakerSharks.Apis.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MakerSharks.Apis.entities.User;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
