package com.example.demoTTS2.Repository;

import com.example.demoTTS2.Model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer > {
    UserEntity findByUsername(String username);
    Boolean existsByUsername(String username);
    void deleteByUif(Integer username);
}
