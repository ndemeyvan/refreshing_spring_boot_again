package com.ndemeyva.learnspring.learn_spring.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndemeyva.learnspring.learn_spring.dto.UserDto;
import com.ndemeyva.learnspring.learn_spring.models.request.UserDetailsRequestModel;
import com.ndemeyva.learnspring.learn_spring.models.response.UserRes;
import com.ndemeyva.learnspring.learn_spring.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers() {
        return "Get all user called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User called";
    }

    /*
     * create new user
     */
    @PostMapping
    public UserRes createUser(@RequestBody UserDetailsRequestModel userDetail) {
        UserRes returnValue = new UserRes();
        UserDto userDto = new UserDto();
        // Copy user request data to the dto
        BeanUtils.copyProperties(userDetail, userDto);
        // Call service and Copy userDto response to return value
        UserDto createdValue = userService.createUser(userDto);
        BeanUtils.copyProperties(createdValue, returnValue);
        //
        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "Update User called";
    }

}
