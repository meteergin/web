package com.erg01.controller;

import com.erg01.domain.LoginVM;
import com.erg01.config.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    JWTToken jwtToken;

    public LoginController(JWTToken jwtToken) {
        this.jwtToken = jwtToken;
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        LoginVM loginVM = new LoginVM();
        model.addAttribute("loginVM", loginVM);
        return "login";
    }

    @PostMapping("/login")
    public void loginPost(LoginVM loginVM) {
        final String uri = "http://localhost:8081/api/authenticate";

        RestTemplate restTemplate = new RestTemplate();
        try {
            jwtToken = restTemplate.postForObject(uri, loginVM, JWTToken.class);
            System.out.println(jwtToken);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode().toString());
        }
    }
}
