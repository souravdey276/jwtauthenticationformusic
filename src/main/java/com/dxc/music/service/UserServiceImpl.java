package com.dxc.music.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dxc.exception.UserExistsException;
import com.dxc.exception.UserNotFoundException;
import com.dxc.music.model.User;
import com.dxc.music.repository.AuthenticationRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private AuthenticationRepository repository;

	@Override
	public User updateUser(String email, User user) {
		User  userToUpdate = repository.findById( email).get();
	     if(userToUpdate!=null)
	     {
	    	 repository.save(user);
	     }
		return user;
	}

	@Override
	public User find(String email, String password) {
		User user=repository.findById(email).get();
		return user;
	}

	@Override
	public User addUser(User user) throws UserExistsException {
		boolean isUserExists=false;
		try {
			isUserExists = isUserExists(user.getEmail());
		} catch (UserNotFoundException e) {
		
			e.printStackTrace();
		}
		if(isUserExists)
		{
			throw new UserExistsException();
		}
		else
		{
			
			return repository.save(user);
		}

	}

	@Override
	public boolean isUserExists(String email) throws UserNotFoundException {
		Optional<User> user= repository.findById(email);
		if(user.isPresent())
		{
			return true;
		}
		else
			throw new UserNotFoundException();
	}
	
	
	

}
