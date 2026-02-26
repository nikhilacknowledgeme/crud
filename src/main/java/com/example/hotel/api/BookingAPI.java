package com.example.hotel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Booking;
import com.example.hotel.service.BookingService;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingAPI {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable Integer id) {
		Booking booking= bookingService.fetchBookingById(id);
		return ResponseEntity.ok(booking);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
		bookingService.deleteBookingById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> updateBooking(@RequestBody Booking booking) {
		String message = bookingService.updateBooking(booking);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
	}

}
