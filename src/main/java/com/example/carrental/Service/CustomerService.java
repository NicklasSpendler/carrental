package com.example.carrental.Service;

import com.example.carrental.Model.Customer;
import com.example.carrental.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAll() {
        //SQL code
        return customerRepo.fetchAll();
    }

    public Customer addCustomer(Customer c) {
        return customerRepo.addCustomer(c);
    }

    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    public Customer updatePerson (int id, Customer c) {
        return customerRepo.updatePerson(id, c);
    }
}
