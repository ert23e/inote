package com.whencout.inote.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControl {
    
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "index";
    }
}
