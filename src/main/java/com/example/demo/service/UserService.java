package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean saveMessage(UserModel feedback) {
        try {
            userRepository.save(feedback);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserModel fetchFeedback(UUID uuid) {
        return userRepository.findOneByUuid(uuid);
    }

}
