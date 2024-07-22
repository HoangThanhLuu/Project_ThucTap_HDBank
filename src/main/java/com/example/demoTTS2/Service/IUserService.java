package com.example.demoTTS2.Service;

import com.example.demoTTS2.Model.UserEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IUserService {
    String loginUserAdmin(String username,String password);

    UserEntity createUser(UserEntity usersEntity);
    void deleteUser(Integer id);
    UserEntity getUserfromJWT(@RequestHeader("Authorization") String token) throws  Exception;
}
