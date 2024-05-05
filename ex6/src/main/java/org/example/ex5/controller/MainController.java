package org.example.ex5.controller;

import org.example.ex5.beans.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {

        return "index.html";
    }

    @GetMapping("/requestScope")
    public String loginGet() {

        return "requestScope.html";
    }

    @PostMapping("/requestScope")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {

        var lp = new LoginProcessor(username, password);

        if (lp.isLogin()) {
            model.addAttribute("message", "You are now logged in.");
        } else {
            model.addAttribute("message", "Login failed!");
        }

        return "requestScope.html";
    }

}
