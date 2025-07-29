package com.example.picthfire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    int id;

    String fname;
    String lname;
    int phone;
    String nic;
    String email;
    String position;
    String password;

}
