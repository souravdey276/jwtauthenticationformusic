package com.dxc.music.service;


import com.dxc.exception.UserExistsException;
import com.dxc.exception.UserNotFoundException;
import com.dxc.music.model.User;

public interface UserService {
	
	User updateUser(String email, User user);
	User find(String email,String password);
    User addUser(User user) throws UserExistsException ;
    public boolean isUserExists(String email) throws UserNotFoundException;
	
     

}
