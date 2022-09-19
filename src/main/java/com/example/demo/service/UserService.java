package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public boolean saveMssg(UserModel feedback){
        try {
            userRepo.save(feedback);
            return true;
        }
        catch ( Exception e){
            return false;
        }
    }
}
