package com.cg.feedback.restcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestController {

    public String welcome(){
        return "Welcome";
    }
    public static void main(String...args){
        SpringApplication.run(SpringRestController.class, args);
    }
}