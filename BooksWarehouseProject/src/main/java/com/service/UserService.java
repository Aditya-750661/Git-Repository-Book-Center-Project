package com.service;

import java.util.List;

import com.model.Address;
import com.model.User;

public interface UserService {

	public User registerUse(User user);

	public User  findUserById(long id);

	public boolean loginCredentials(String username,String password);

	public void delete(long id);

	public User updateUser(long id , User user);
}
