package com.example.demoTTS2.Service;

import com.example.demoTTS2.Component.JwtTokenUtil;
import com.example.demoTTS2.Repository.UserRepo;

public class RoleService implements IRoleService{
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepo userRepo;

    public RoleService(JwtTokenUtil jwtTokenUtil, UserRepo userRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
    }

}
