package com.fedyukov.cousework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping(value = "/start")
    public String start() {
        return "index";
    }
}
