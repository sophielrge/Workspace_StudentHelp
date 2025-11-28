package fr.insa.StudentHelp.AuthManager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.StudentHelp.AuthManager.model.*;
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
    
    @PutMapping("/change-password")
    public User changePassword(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String oldPassword = body.get("oldPassword");
        String newPassword = body.get("newPassword");

        return service.changePassword(email, oldPassword, newPassword);
    }
    
    @GetMapping("/student-info/{email}")
    public Student getStudentInfo(@PathVariable String email) {
        return service.getStudentInfo(email);
    }
}