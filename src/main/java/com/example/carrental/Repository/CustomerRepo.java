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
        String sql = "INSERT INTO privatecustomer (customerID,firstName, lastName, zipCode, cityName, adress, mobileNr, email, driversLicenceNumber) VALUES(?,?,?,?,?,?,?,?,?)";
        template.update(sql, c.getCustomerID(), c.getFirstName(), c.getLastName(), c.getZipCode(), c.getCityName(), c.getAdress(), c.getMobileNr(), c.getEmail(), c.getDriversLicenceNumber());
        return null;
    }

    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM privatecustomer WHERE customerID = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean deleteCustomer(int id) {
        String sql = "DELETE FROM privatecustomer WHERE customerID = ?";
        return template.update(sql,id) > 0;
    }

    public Customer updatePerson (int id, Customer c) {
        String sql = "UPDATE privatecustomer SET firstName = ?, lastName = ?, zipCode = ?, cityName = ?, adress = ?, mobileNr = ?, email = ?, driversLicenceNumber = ?, CustomerSinceDate = ? WHERE customerID = ?";
        template.update(sql, c.getFirstName(), c.getLastName(), c.getZipCode(), c.getCityName(), c.getAdress(), c.getMobileNr(), c.getEmail(), c.getDriversLicenceNumber(), c.getCustomerSinceDate(), id);
        return null;
    }
}
