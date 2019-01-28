package com.example.demo;

import java.util.List;

public interface IUserDAO {

	public UserModel getUserById(int userId);
	public List<UserModel> getAllUsers();
	 public boolean addUser(UserModel newUser);
	 public boolean updateUser(UserModel user);
	 public boolean deleteUser(int userId);
	 public boolean findByFirstName(String firstName);

}
