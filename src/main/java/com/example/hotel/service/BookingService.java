package com.example.hotel.service;

import com.example.hotel.model.Booking;

public interface BookingService {
	
	public Booking fetchBookingById(Integer id);
	
	public void deleteBookingById(Integer id);
	
	public String updateBooking(Booking booking);

}
