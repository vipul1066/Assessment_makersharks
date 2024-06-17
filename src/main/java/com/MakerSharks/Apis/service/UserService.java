package com.MakerSharks.Apis.service;

import java.util.List;
import java.util.Optional;

import com.MakerSharks.Apis.entities.User;

public interface UserService {
    User saveUser(User user);
    boolean isUserExistByEmail(String email);
    Optional<User> getUserById(String id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
}
