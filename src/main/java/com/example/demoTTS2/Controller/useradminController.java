package com.example.demoTTS2.Controller;

import com.example.demoTTS2.Model.RoleEntity;
import com.example.demoTTS2.Model.UserEntity;
import com.example.demoTTS2.Repository.RoleRepo;
import com.example.demoTTS2.Service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class useradminController {
    private RoleRepo roleRepo;
    private final IUserService iUserService;

    public useradminController(RoleRepo roleRepo, IUserService iUserService) {
        this.roleRepo = roleRepo;
        this.iUserService = iUserService;
    }
@PostMapping("setRole")
    public ResponseEntity<?> setRole(@RequestHeader("Authorization") String authHeader,@RequestBody RoleEntity roleEntity){
        try {  String extractedToken=authHeader.substring(7);
            UserEntity optinalUser=iUserService.getUserfromJWT(extractedToken);
            RoleEntity Role= roleRepo.findByUsername(optinalUser.getUsername());
            Role.setAddRole(roleEntity.getAddRole());
            Role.setDeleteRole(roleEntity.getDeleteRole());
            Role.setQueryCustomerRole(roleEntity.getQueryCustomerRole());
            Role.setEditRole(roleEntity.getEditRole());
            Role.setReadSalaryRole(roleEntity.getReadSalaryRole());
            roleRepo.save(Role);
            return ResponseEntity.ok("ThanhCong");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/api/edit-user")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/api/add-user")
    public ResponseEntity<?> test2(){
        return ResponseEntity.ok("ok2");
    }
}
