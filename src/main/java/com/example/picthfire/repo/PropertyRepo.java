package com.example.picthfire.repo;

import com.example.picthfire.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

    @Query(value="select max(id) from property", nativeQuery = true)
    Integer getMaxIdProp();



}
