package com.dxc.music.tokengenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.dxc.music.model.User;

import com.dxc.music.tokengenerator.TokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenGeneratorImpl implements TokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		// TODO Auto-generated method stub
		String jwtToken=Jwts.builder().setId(user.getEmail()).setSubject(user.getPassword()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	    System.out.println(jwtToken);
		Map<String,String> tokenMap=new HashMap<>();
		tokenMap.put("token", jwtToken);
		tokenMap.put("message", "User successfully logged in");
         return tokenMap;		
	}

}
