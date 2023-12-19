package com.example.employeecrudmvc.service;

import com.example.employeecrudmvc.dao.CustomerDao;
import com.example.employeecrudmvc.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public List<Customer> findAllCustomer() {
        return customerDao.findAll();
    }

    public void createCustomer(@Valid Customer customer) {
        customerDao.save(customer);
    }
}