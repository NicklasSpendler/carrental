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
        String sql = "SELECT bookingID, booking.customerID, firstName, lastName, model, booking.carID FROM carrental.booking JOIN privatecustomer ON booking.customerID = privatecustomer.customerID JOIN cars ON booking.carID = cars.carID order by bookingID";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }


    public Booking addBooking(Booking c) {
        String sql = "INSERT INTO booking VALUES(?,?, ?, ?, ?)";
        template.update(sql, c.getBookingID(), c.getCustomerID(), c.getCarID(), c.getRentDate(), c.getReturnDate());
        return null;
    }



    public Booking findBookingByID(int id) {
        String sql = "SELECT * FROM booking WHERE bookingID = ?";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public Boolean deleteBooking(int id) {
        String sql = "DELETE FROM booking WHERE bookingID = ?";
        return template.update(sql,id) > 0;
    }


    public void updateBooking (int id, Booking b) {
        String sql = "UPDATE booking SET rentDate = ?,returnDate = ? WHERE bookingID = ?";
        template.update(sql ,b.getRentDate(), b.getReturnDate(), id);
    }

}
