package com.example.demoTTS2.Service;

import com.example.demoTTS2.Model.CustomerEntity;
import com.example.demoTTS2.Repository.CustoRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  ICustomerService{
    private final CustoRepo customer;

    public CustomerService(CustoRepo customer) {
        this.customer = customer;
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customerEntity) {
        if(customer.existsByEmpno(customerEntity.getEmpno())){
            throw new DataIntegrityViolationException("Customer already exists");
        }
        return  customer.save(customerEntity);

    }
}
