//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.form.UserForm;
//import com.example.demo.repository.UserMapper;
//
//@Service
//public class UserService implements UserDetailsService {
//	@Autowired
//	private UserMapper userMapper;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	// 認証
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return userMapper.certificate(username);
//
//	}
//
//	// 新規登録
//	public void insertOne(UserForm user) {
//		// パスワードをハッシュ化して、insertOne()に渡すオブジェクトにセット。
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//		userMapper.insertOne(user);
//	}
//
//	// 1件検索
//	public Optional<UserForm> findById(Integer id) {
//		return userMapper.findById(id);
//	}
//
//	// 全件取得
//	public List<UserForm> getUserList() {
//		return userMapper.findAll();
//	}
//
//	// 更新
//	public void updateOne(Integer id, String username, String password, String authorities) {
//		userMapper.updateOne(id, username, password, authorities);
//	}
//
//	// 削除
//	public void deleteOne(int id) {
//		userMapper.deleteOne(id);
//	}
//}

