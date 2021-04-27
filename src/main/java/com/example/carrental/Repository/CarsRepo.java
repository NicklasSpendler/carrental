package com.example.carrental.Repository;

import com.example.carrental.Model.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarsRepo {
    @Autowired
    JdbcTemplate template;

    public List<Cars> fetchAll() {
        String sql = "SELECT * FROM cars";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        return template.query(sql, rowMapper);
    }

    public Cars addCar(Cars c) {
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getCarID(), c.getCarType(), c.getBrand(), c.getModel(), c.getRegNumberPlate(), c.getFirstRegYearMonth() , c.getKmDriven());
        return null;
    }

    public Cars findCarById(int id) {
        String sql = "SELECT * FROM cars WHERE carID = ?";
        RowMapper<Cars> rowMapper = new BeanPropertyRowMapper<>(Cars.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE carID = ?";
        return template.update(sql,id) > 0;
    }

    public void updateCar (int id, Cars c) {
        String sql = "UPDATE cars SET carType = ?,brand = ?,model = ?,regNumberPlate = ?,firstRegYearMonth = ?,kmDriven = ? where carID = ?";
        template.update(sql ,c.getCarType(), c.getBrand(), c.getModel(), c.getRegNumberPlate(), c.getFirstRegYearMonth(), c.getKmDriven(), c.getCarID());
    }
}