package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
public class VsapApplication {
    public static void main(String[] args) {
        SpringApplication.run(VsapApplication.class, args);
    }
    @Scheduled(initialDelay = 300000L,fixedRate =1000L)
     void expireTime(){
        System.exit(0);
    }
}
