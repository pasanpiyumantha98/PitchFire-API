package com.example.picthfire.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    int id;

    String fname;
    String lname;
    int phone;
    String nic;
    String email;
    String position;
    String password;

}
