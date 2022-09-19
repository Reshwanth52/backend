package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000/feedback")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/sendMssg")
    public String saveMssg(@RequestBody UserModel feedback){
//        Logger logger = LoggerFactory.getLogger(UserController.class);
//        logger.warn(String.valueOf(feedback));
        String mssg = feedback.getMssg();
        if(mssg != null && !"".equals(mssg)){
            if(service.saveMssg(feedback)){
                return "saved Successfully";
            }
            else{
                return "error Occurred";
            }
        }
        else{
            return "Empty mssg cant be sent";

        }
//        return feedback;
    }

//    public String getMssg(){
//
//    }
}
