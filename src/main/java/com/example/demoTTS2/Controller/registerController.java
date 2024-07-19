package com.example.demoTTS2.Controller;

import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
    private final IUserService iUserService;

    public registerController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        iUserService.createUser(userEntity);
        return ResponseEntity.ok("OK !");
    }
}
