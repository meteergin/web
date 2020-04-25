package com.erg01.controller;

import com.erg01.domain.LoginVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping({"/"})
    public String hello(Model model) {
        return "index";
    }

}
