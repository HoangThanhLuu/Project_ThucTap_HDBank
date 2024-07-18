package com.example.demoTTS2.Service;

import com.example.demoTTS2.Model.UserEntity;
import org.springframework.stereotype.Service;

public interface ILoginService {
    String loginUserAdmin(String username,String password);

    UserEntity createUser(UserEntity usersEntity);
}
