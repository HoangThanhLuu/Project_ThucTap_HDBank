package com.example.demoTTS2.Controller.CRUDCustomer;

import com.example.demoTTS2.Model.CustomerEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Service.CustomerService;
import com.example.demoTTS2.Service.ICustomerService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class registerCustomerController {

    private final ICustomerService customerService;

    public registerCustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add/customer")
    public ResponseEntity<?> registerUser(@RequestBody CustomerEntity userEntity){
     customerService.registerCustomer(userEntity);
        return ResponseEntity.ok("post success");
    }


}
