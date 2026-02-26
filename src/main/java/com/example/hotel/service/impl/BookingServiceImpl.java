package com.example.hotel.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.entities.BookingEntity;
import com.example.hotel.mapper.ObjectMapper;
import com.example.hotel.model.Booking;
import com.example.hotel.repositories.BookingRepository;
import com.example.hotel.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepo;

	@Override
	public Booking fetchBookingById(Integer id) {
		Optional<BookingEntity> opt = bookingRepo.findById(id);
		BookingEntity entity = opt.get();
		Booking booking = ObjectMapper.mapBookingEntityToBooking(entity);
		return booking;
	}

	@Override
	public void deleteBookingById(Integer id) {
		bookingRepo.deleteById(id);
	}

	@Override
	public String updateBooking(Booking booking) {
		bookingRepo.updateBookingDetails(booking.getBookingCheckIn(), booking.getBookingCheckOut(), booking.getBookingId());
		return "Booking details are updated in Database.";
	}

}
