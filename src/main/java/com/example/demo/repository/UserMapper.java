package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.UserModel;
import com.example.demo.form.UserForm;

@Mapper
public interface UserMapper {
	public UserModel certificate(@Param("username") String username);

	// 1件検索
	public Optional<UserForm> findById(Integer id);

	// 全件取得
	public List<UserForm> findAll();

	// 登録
	public void insertOne(UserForm user);

	// 更新
	public void updateOne(@Param("id") int id, @Param("username") String username, @Param("password") String password,
			@Param("roles") String roles);

	// 削除
	public Integer deleteOne(int id);
}

