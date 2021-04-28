package com.example.carrental.Repository;

import com.example.carrental.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepo {
    @Autowired
    JdbcTemplate template;

    public List<Booking> fetchAll() {
        String sql = "SELECT bookingID, booking.customerID, firstName, lastName, model, booking.carID FROM carrental.booking JOIN privatecustomer ON booking.customerID = privatecustomer.customerID JOIN cars ON booking.carID = cars.carID";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }

    /*
    public Booking addCar(Booking c) {
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getCarID(), c.getCarType(), c.getBrand(), c.getModel(), c.getRegNumberPlate(), c.getFirstRegYearMonth() , c.getKmDriven());
        return null;
    }

     */

    public Booking findBookingByID(int id) {
        String sql = "SELECT * FROM booking WHERE bookingID = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean deleteBooking(int id) {
        String sql = "DELETE FROM booking WHERE bookingID = ?";
        return template.update(sql,id) > 0;
    }

    /*
    public void updateCar (int id, Cars c) {
        String sql = "UPDATE cars SET carType = ?,brand = ?,model = ?,regNumberPlate = ?,firstRegYearMonth = ?,kmDriven = ? where carID = ?";
        template.update(sql ,c.getCarType(), c.getBrand(), c.getModel(), c.getRegNumberPlate(), c.getFirstRegYearMonth(), c.getKmDriven(), c.getCarID());
    }
     */
}
