package com.example.hotel.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.entities.HotelEntity;
import com.example.hotel.entities.HotelRoomDetailsEntity;
import com.example.hotel.mapper.ObjectMapper;
import com.example.hotel.model.Hotel;
import com.example.hotel.model.HotelRoomDetails;
import com.example.hotel.repositories.HotelRepository;
import com.example.hotel.repositories.HotelRoomDetailsRepository;
import com.example.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepo;
	
	@Autowired
	HotelRoomDetailsRepository roomDetailsRepo;

	@Override
	public Hotel fetchHotelDetailsById(Integer id) {
		
		Optional<HotelEntity> opt = hotelRepo.findById(id);
		HotelEntity entity = opt.get();
		Hotel hotel = ObjectMapper.mapHotelEntityToHotel(entity);
		return hotel;
		
	}

	@Override
	public String addHotelDetails(Hotel hotel) {
		HotelEntity entity = ObjectMapper.mapHotelToHotelEntity(hotel);
		hotelRepo.save(entity);
		return "HotelDetails are added....";
	}

	@Override
	public HotelRoomDetails fetchHotelRoomDetailsById(Integer id) {
		Optional<HotelRoomDetailsEntity> opt = roomDetailsRepo.findById(id);
		HotelRoomDetailsEntity entity = opt.get();
		HotelRoomDetails roomDetails = ObjectMapper.mapHotelRoomDetailsEntityToHotelRoomDetails(entity);
		return roomDetails;
	}

	@Override
	public void deleteRoomDetailsById(Integer id) {
		roomDetailsRepo.deleteById(id);
	}

}
