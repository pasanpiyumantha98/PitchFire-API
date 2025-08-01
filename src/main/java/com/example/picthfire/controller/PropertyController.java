package com.example.picthfire.controller;


import com.example.picthfire.dto.PropDto;
import com.example.picthfire.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/prop")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/reg")
    public String regprop(@RequestBody PropDto propDto)
    {
        return propertyService.regprop(propDto);
    }


}
