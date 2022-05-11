package com.hotel.springbootbackend.controller;

import com.hotel.springbootbackend.exception.ResourceNotFoundExeption;
import com.hotel.springbootbackend.model.Booking;
import com.hotel.springbootbackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//common base url for these rest apis
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    //crete Booking
    //@RequestBody this annotation basically convert JSON to java
    //@PostMapping("/employee")    you dont need to specify URL here cyz up there we did it just annotation is enough
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

    //getBookingById
    @GetMapping("{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable long id){
        Booking booking = bookingRepository.findById(id)
                                            .orElseThrow(()-> new ResourceNotFoundExeption("Booking not exist with id:" + id));
        return ResponseEntity.ok(booking);
    }

    //update book
    @PutMapping("{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable long id,@RequestBody Booking bookingDetails){

        Booking updateBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Booking not exist with ID" + id));

        updateBooking.setName(bookingDetails.getName());
        updateBooking.setCheckInDate(bookingDetails.getCheckInDate());
        updateBooking.setCheckOutDate(bookingDetails.getCheckOutDate());
        updateBooking.setGuests(bookingDetails.getGuests());
        updateBooking.setEmail(bookingDetails.getEmail());
        updateBooking.setKids(bookingDetails.getKids());

        bookingRepository.save(updateBooking);
        return ResponseEntity.ok(updateBooking);
    }
    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable long id){
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Booking not found under id: " + id));
        bookingRepository.delete(booking);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
