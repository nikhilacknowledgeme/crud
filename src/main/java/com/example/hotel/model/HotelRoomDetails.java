package com.example.hotel.model;

import com.example.hotel.entities.HotelEntity;

import lombok.Data;

@Data
public class HotelRoomDetails {
	private Integer roomId;
	
	private String roomType;
	
	private Double roomPrice;
	
	private Hotel hotel;


}
