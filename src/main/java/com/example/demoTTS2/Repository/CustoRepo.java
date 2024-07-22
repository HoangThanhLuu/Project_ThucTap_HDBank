package com.example.demoTTS2.Repository;

import com.example.demoTTS2.Model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustoRepo extends JpaRepository<CustomerEntity,Integer> {
    Boolean existsByEmpNo(Integer mnv);

}
