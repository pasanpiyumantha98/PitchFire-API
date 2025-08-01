package com.example.picthfire.services;


import com.example.picthfire.dto.PropDto;
import com.example.picthfire.model.Property;
import com.example.picthfire.repo.PropertyRepo;
import com.example.picthfire.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PropertyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PropertyRepo propertyRepo;


    public String regprop(PropDto propDto) {

    Integer maxid = propertyRepo.getMaxIdProp();

    if (maxid == null) {
        propDto.setId(1);

    } else
    {
     propDto.setId(maxid + 1);
    }

    propertyRepo.save(modelMapper.map(propDto,Property.class));

    return "success";


    }



}
