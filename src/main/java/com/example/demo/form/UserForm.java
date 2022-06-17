package com.example.demo.form;

import lombok.Data;

@Data
public class UserForm {
	private String id;
	private String username;
    private String password;
    private String authority;
}
