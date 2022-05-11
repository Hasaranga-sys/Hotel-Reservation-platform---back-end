package com.hotel.springbootbackend.repository;

import com.hotel.springbootbackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    //crud methods




}
