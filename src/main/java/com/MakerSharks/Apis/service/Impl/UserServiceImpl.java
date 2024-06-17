package com.MakerSharks.Apis.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MakerSharks.Apis.entities.User;
import com.MakerSharks.Apis.helpers.PasswordBcrypt;
import com.MakerSharks.Apis.repositories.UserRepo;
import com.MakerSharks.Apis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    // @Autowired
    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();

        user.setUserId(userId);
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());

        String hashPassword = PasswordBcrypt.hashPassword(user.getPassword());
        user.setPassword(hashPassword);
        
        user.setPhoneNumber(user.getPhoneNumber());
        user.setAddress(user.getAddress());

        //logger.info("User saved successfully");

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
       return userRepo.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);

        return user != null ? true : false;
    }

}
