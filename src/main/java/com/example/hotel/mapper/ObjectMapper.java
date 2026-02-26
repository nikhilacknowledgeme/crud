package com.example.hotel.mapper;

import org.springframework.beans.BeanUtils;

import com.example.hotel.entities.BookingEntity;
import com.example.hotel.entities.HotelEntity;
import com.example.hotel.entities.HotelRoomDetailsEntity;
import com.example.hotel.model.Booking;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.HotelRoomDetails;

public class ObjectMapper {
	
	public static Hotel mapHotelEntityToHotel(HotelEntity entity) {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(entity, hotel);
		return hotel;
	}
	
	public static HotelEntity mapHotelToHotelEntity(Hotel hotel) {
		HotelEntity entity = new HotelEntity();
		BeanUtils.copyProperties(hotel, entity);
		return entity;
	}
	
	public static HotelRoomDetails mapHotelRoomDetailsEntityToHotelRoomDetails(HotelRoomDetailsEntity entity) {
		HotelRoomDetails roomDetails = new HotelRoomDetails();
		BeanUtils.copyProperties(entity, roomDetails);
		roomDetails.setHotel(mapHotelEntityToHotel(entity.getHotel()));
		return roomDetails;
	}
	
	public static Booking mapBookingEntityToBooking(BookingEntity entity) {
		Booking booking = new Booking();
		BeanUtils.copyProperties(entity, booking);
		booking.setBookingRoomDetails(mapHotelRoomDetailsEntityToHotelRoomDetails(entity.getBookingRoomDetails()));
		return booking;
	}

}
