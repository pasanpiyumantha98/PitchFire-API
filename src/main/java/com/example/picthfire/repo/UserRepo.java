package com.example.picthfire.repo;

import com.example.picthfire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value="select max(id) from user", nativeQuery = true)
    Integer findMaxId();

    @Query(value="select * from user where nic=?1 or email=?2 ", nativeQuery = true)
    User findUserExists(String nic,String email);

}
