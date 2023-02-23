package com.dxc.music.tokengenerator;

import java.util.Map;

import com.dxc.music.model.User;

public interface TokenGenerator {
    
	Map<String,String> generateToken(User user);
}
