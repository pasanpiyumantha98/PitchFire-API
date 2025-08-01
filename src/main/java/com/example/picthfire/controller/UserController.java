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

    @PostMapping("/login")
    public int login(@RequestBody UserDto userDto) {

        return userService.loguser(userDto);
    }

    @PostMapping("/remove")
    public String remove(@RequestBody UserDto userDto) {
       return userService.removeUser(userDto);
    }

    @PostMapping("/changepass")
    public String changepass(@RequestBody UserDto userDto) {
        return userService.changepass(userDto);
    }

}
