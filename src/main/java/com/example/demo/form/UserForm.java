package com.example.demo.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserForm {
	
	private Integer id;
	
	@NotBlank(message = "* Usernameを記入してください")
	private String username;
	
	@NotBlank(message = "* Passwordを記入してください")
    private String password;
	
	@NotBlank(message = "* 権限を選択してください")
    private String roles;
    
}
