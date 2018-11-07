package com.apap.tutorial8.service;

import com.apap.tutorial8.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	UserRoleModel getUserDetailByUsername(String username);
	public String encrypt(String password);
	boolean isMatch(String rawPassword, String encodedPassword);
}
