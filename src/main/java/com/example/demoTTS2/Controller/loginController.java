package com.example.demoTTS2.Controller;

import com.example.demoTTS2.Model.UserAdminEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {
@PostMapping("/loginAdmin")
public ResponseEntity<?> login(@ResponseBody UserAdminEntity){

}
}
