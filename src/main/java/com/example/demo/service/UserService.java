package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public UserModel fetchFeedback(UUID uuid) {
        return userRepo.findOneByUuid(uuid);
    }

    @Scheduled(cron="* */5 * * * *")
    public void test(){

        Logger logger = LoggerFactory.getLogger(UserService.class);

        logger.warn(String.valueOf("Testing ..."));

//        throw new RuntimeException("Time Limit Exceed");

        System.exit(0);

    }

}
