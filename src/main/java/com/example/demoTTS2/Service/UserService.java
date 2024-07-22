package com.example.demoTTS2.Service;

import com.example.demoTTS2.Component.JwtTokenUtil;
import com.example.demoTTS2.Model.RoleEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.RoleRepo;
import com.example.demoTTS2.Repository.UserRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Service
public class UserService implements IUserService {
    private final  UserRepo userRepo;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepo roleRepo;
    public UserService(UserRepo userRepo, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepo = roleRepo;
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
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setUsername(username);
        roleRepo.save(roleEntity);
        return userRepo.save(usersEntity);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserEntity getUserfromJWT(String token) throws Exception {
        if(jwtTokenUtil.isTokenExpired(token)) {
            throw new Exception("Token is expired");
        }
        String username=jwtTokenUtil.extractUsername(token);
        UserEntity usersEntity= userRepo.findByUsername(username);
        if ((usersEntity==null)) {
            throw new Exception("User not found");
        } else {
            return usersEntity;
        }
    }
}
