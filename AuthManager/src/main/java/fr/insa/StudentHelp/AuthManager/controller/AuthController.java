package fr.insa.StudentHelp.AuthManager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.StudentHelp.AuthManager.model.User;
import fr.insa.StudentHelp.AuthManager.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> req) {
        return service.register(req.get("email"), req.get("password"));
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> req) {
        return service.login(req.get("email"), req.get("password"));
    }
}