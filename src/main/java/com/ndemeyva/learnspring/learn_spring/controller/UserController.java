package com.ndemeyva.learnspring.learn_spring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Get all user called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User called";
    }

    @PostMapping
    public String createUser() {
        return "Create User called";
    }

    @PutMapping
    public String updateUser() {
        return "Update User called";
    }

}
