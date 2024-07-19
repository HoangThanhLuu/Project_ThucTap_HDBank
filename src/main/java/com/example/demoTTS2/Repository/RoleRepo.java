package com.example.demoTTS2.Repository;

import com.example.demoTTS2.Model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity,Integer > {
    RoleEntity findByUsername(String username);
}
