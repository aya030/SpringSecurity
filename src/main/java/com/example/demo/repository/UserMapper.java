package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.UserModel;

@Mapper
public interface UserMapper {
    public UserModel certificate(@Param("username") String username);
}