package com.example.demoTTS2.Controller;

import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Service.ILoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class registerController {
    private final ILoginService iLoginService;

    public registerController(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        iLoginService.createUser(userEntity);
        return ResponseEntity.ok("OK !");
    }
}
