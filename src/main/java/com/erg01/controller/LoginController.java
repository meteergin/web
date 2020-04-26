package com.erg01.controller;

import com.erg01.common.RestUrl;
import com.erg01.domain.LoginVM;
import com.erg01.domain.JWTToken;
import com.erg01.domain.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class LoginController {

    JWTToken jwtToken;
    RestTemplate restTemplate;
    User user;

    public LoginController(JWTToken jwtToken, RestTemplate restTemplate, User user) {
        this.jwtToken = jwtToken;
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        LoginVM loginVM = new LoginVM();
        model.addAttribute("loginVM", loginVM);
        return "login";
    }

    @PostMapping("/login")
    public void loginPost(LoginVM loginVM) {
        try {
            jwtToken = restTemplate.postForObject(RestUrl.AUTHENTICATE, loginVM, JWTToken.class);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", "Bearer " + jwtToken.getIdToken());
            HttpEntity request = new HttpEntity(headers);
            ResponseEntity<User> response = restTemplate.exchange(
                    RestUrl.ACCOUNT,
                    HttpMethod.GET,
                    request,
                    User.class
            );

            user = response.getBody();

            System.out.println(user);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode().toString());
        }
    }
}
