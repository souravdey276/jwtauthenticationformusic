package com.dxc.music.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.UserExistsException;

import com.dxc.music.model.User;
import com.dxc.music.repository.AuthenticationRepository;
import com.dxc.music.service.UserService;
import com.dxc.music.tokengenerator.TokenGenerator;
import com.dxc.music.tokengenerator.TokenGeneratorImpl;

@RestController

//http://localhost:4444/api/authentication/add/User
//http://localhost:4444/api/authentication/login/stackroute@niit.com
@CrossOrigin(origins="http://localhost:4200")

@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	private HttpSession session;
	@Autowired
	private AuthenticationRepository repository;
	@Autowired
	private UserService service;
	
	@PostMapping("add/User")
	public ResponseEntity<?> addUser(@RequestBody User user) throws UserExistsException
	{
	    User addUser=service.addUser(user);
		if(addUser!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
	}
	
	
	
	@PutMapping("/updateUser/{email}")
	public User updateUser(@PathVariable String email, @RequestBody User user)
	{
		return service.updateUser(email, user);
	}
	
	/*@GetMapping("/login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable String email,@PathVariable String password, HttpSession session)
	{
		User userFound=repository.findById(email).get();
		if(userFound!=null)
		{
		session.setAttribute("login_details", userFound.getEmail());
		this.session=session;
		TokenGenerator token=new TokenGeneratorImpl();
		Map<String,String> map=token.generateToken(userFound);
		return new ResponseEntity<>(map,HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found",HttpStatus.BAD_REQUEST);
		}*/
	
	
	
	
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<?> login(@PathVariable String email,@PathVariable String password, HttpSession session)
	{
		User userFound=service.find(email, password);
		if(userFound!=null)
		{
		session.setAttribute("login_details", userFound.getEmail());
		this.session=session;
		TokenGenerator token=new TokenGeneratorImpl();
		Map<String,String> map=token.generateToken(userFound);
		return new ResponseEntity<>(map,HttpStatus.OK);
		}
		return new ResponseEntity<>("User not found",HttpStatus.BAD_REQUEST);
		}
	
	
	
	
   	
    @GetMapping("/logout")
	public void logOut()
	{
	 session.invalidate();	
		
	}
	
}
