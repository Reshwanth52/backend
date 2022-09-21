package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000/feedback")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/sendMssg")
    public UserModel saveMssg(@RequestBody UserModel feedback) throws Exception{
//        Logger logger = LoggerFactory.getLogger(UserController.class);
//
//        logger.warn(String.valueOf(feedback));
        String mssg = feedback.getMssg();
        if(mssg != null && !"".equals(mssg)){
            if(service.saveMssg(feedback)){
                return feedback;
            }
            else{
                 throw new Exception("Error Occurred");
            }
        }
        else {
            throw new Exception("Empty Message Can't be sent");

        }
    }

    @GetMapping("/receiveMssg/{uuid}")
    public UserModel getFeedback(@PathVariable UUID uuid){
        Logger logger = LoggerFactory.getLogger(UserController.class);

        logger.warn(String.valueOf(uuid));
        return service.fetchFeedback(uuid);
    }

    @GetMapping("/getUUID")
    public UUID getUUID(){
        return UUID.randomUUID();
    }
}
