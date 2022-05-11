package com.hotel.springbootbackend;

import com.hotel.springbootbackend.model.Booking;
import com.hotel.springbootbackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private BookingRepository bookingRepository;
	@Override
	public void run(String... args) throws Exception {
		Booking booking = new Booking();
		booking.setName("kavidu");
		booking.setCheckInDate("10");
		booking.setCheckOutDate("15");
		booking.setEmail("hellow@gmail.com");
		booking.setGuests("5");
		booking.setKids("1");
		bookingRepository.save(booking);

		Booking booking1 = new Booking();
		booking1.setName("manidu");
		booking1.setCheckInDate("11");
		booking1.setCheckOutDate("17");
		booking1.setEmail("hwoow@gmail.com");
		booking1.setGuests("5");
		booking1.setKids("1");
		bookingRepository.save(booking1);

	}
}
