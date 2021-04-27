package com.example.carrental.Repository;

import com.example.carrental.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll() {
        String sql = "SELECT * FROM privatecustomer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer addCustomer(Customer c) {
        return null;
    }

    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM privatecustomer WHERE customerID = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean deleteCustomer(int id) {
        return null;
    }

    public Customer updatePerson (int id, Customer c) {
        return null;
    }
}
