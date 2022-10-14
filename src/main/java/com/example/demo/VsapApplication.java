package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class VsapApplication {
    Calendar referenceDate = Calendar.getInstance();
    public final Date referenceTime = referenceDate.getTime();

    public static void main(String[] args) {
        Calendar presentDate = Calendar.getInstance();
        Date presentTime = presentDate.getTime();
        System.out.println(presentTime);
        SpringApplication.run(VsapApplication.class, args);
    }
}
