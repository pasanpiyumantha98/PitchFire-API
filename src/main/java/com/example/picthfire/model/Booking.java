package com.example.picthfire.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Booking {

    @Id
    int id;

    int propid;
    int createdby;
    String cusname;
    int cusphone;
    LocalDate date;
    LocalTime stime;
    LocalTime etime;
    double price;

}
