package com.example.hotel.service;

import com.example.hotel.model.Hotel;
import com.example.hotel.model.HotelRoomDetails;

public interface HotelService {
	
	public Hotel fetchHotelDetailsById(Integer id);
	
	public String addHotelDetails(Hotel hotel);
	
	public HotelRoomDetails fetchHotelRoomDetailsById(Integer id);
	
	public void deleteRoomDetailsById(Integer id);
	

}
