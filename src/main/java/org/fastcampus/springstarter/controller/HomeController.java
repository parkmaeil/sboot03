package org.fastcampus.springstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // new HomeController()
public class HomeController {

    @GetMapping("/hello")
    public String home(Model model){
         return "home"; // home.html
    }
}
