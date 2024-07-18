package com.example.demoTTS2.Service;

import com.example.demoTTS2.Component.JwtTokenUtil;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.UserRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Service
public class LoginService implements ILoginService{
    private final  UserRepo userRepo;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public LoginService(UserRepo userRepo, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String loginUserAdmin(String username, String password) {
        UserEntity optinalUser=userRepo.findByUsername(username);
        if (optinalUser==null) {throw new DataIntegrityViolationException("Not found Username"); }
        if (!passwordEncoder.matches(password,optinalUser.getPassword())){
            throw new BadCredentialsException("Wrong username/password");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(optinalUser);
    }
    @Override
    public UserEntity createUser(UserEntity usersEntity) {
        String username = usersEntity.getUsername();
        if (userRepo.existsByUsername(username)) {
            throw new DataIntegrityViolationException("Username has been created");
        }
        usersEntity.setPassword(passwordEncoder.encode(usersEntity.getPassword()));
        return userRepo.save(usersEntity);
    }
}
