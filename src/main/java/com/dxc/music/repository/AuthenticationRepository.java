package com.dxc.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.music.model.User;

public interface AuthenticationRepository extends JpaRepository<User, String>  {

	
    
}
