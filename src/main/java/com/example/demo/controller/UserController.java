package com.example.demo.controller;

import com.example.demo.VsapApplication;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000/feedback")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sendMessage")
    public UserModel saveMessage(@RequestBody UserModel feedback) throws Exception {
        String message = feedback.getMessage();
        if (message != null && !"".equals(message)) {
            if (userService.saveMessage(feedback)) {
                return feedback;
            } else {
                throw new Exception("Error Occurred");
            }
        } else {
            throw new Exception("Empty Message Can't be sent");
        }
    }
    @GetMapping("/receiveMessage/{uuid}")
    public UserModel getFeedback(@PathVariable UUID uuid) {
        return userService.fetchFeedback(uuid);
    }

    @GetMapping("/getUUID")
    public UUID getUUID() {
        return UUID.randomUUID();
    }

}