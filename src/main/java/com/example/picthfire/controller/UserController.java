package com.example.picthfire.controller;


import com.example.picthfire.dto.UserDto;
import com.example.picthfire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto) {

        return userService.regUser(userDto);

    }

}
