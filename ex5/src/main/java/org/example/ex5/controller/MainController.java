package org.example.ex5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(
            @RequestParam(required = false) String name,
            Model page
    ){

        //page.addAttribute("userName", "IliaLenskii");

        page.addAttribute("userName", (name != null ? name : "IliaLenskii"));

        return "index.html";
    }

    @RequestMapping("/c/{color}")
    public String color(
            @PathVariable String color,
            Model page
    ){

        page.addAttribute("color", color);

        return "color.html";
    }
}
