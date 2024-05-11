package org.example.ex7.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RestControllerSimple {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
