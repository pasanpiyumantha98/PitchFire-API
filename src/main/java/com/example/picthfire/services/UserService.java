package com.example.picthfire.services;

import com.example.picthfire.model.User;
import com.example.picthfire.dto.UserDto;
import com.example.picthfire.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String regUser(UserDto userDto)
    {
        //encrypting password
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        //setting id
        Integer maxid= userRepo.findMaxId();
        if(maxid==null) {
            userDto.setId(101);
        } else {
            maxid = maxid+1;
            userDto.setId(maxid);
        }

        //checking user exists
        User user = userRepo.findUserExists(userDto.getNic(),userDto.getEmail());

        if(user == null) {
            userRepo.save(modelMapper.map(userDto,User.class));
            return "done";
        } else
        {
            return "error";
        }


    }

    public int loguser(UserDto userDto)
    {

        User user = userRepo.findUserExists(userDto.getNic(),userDto.getEmail());

        if(user == null) {
            return -1;
        } else {

            boolean stat = passwordEncoder.matches(userDto.getPassword(),user.getPassword());

            if(stat) {
                return user.getId();
            } else {
                return -2;
            }
        }



    }


}
