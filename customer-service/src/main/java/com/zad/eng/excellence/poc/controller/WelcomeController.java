package com.zad.eng.excellence.poc.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @GetMapping
    public String welcomeUser(){
        return "Welcome to InetelliJ Setup";
    }
}
