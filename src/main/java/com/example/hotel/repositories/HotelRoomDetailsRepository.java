package com.example.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entities.HotelRoomDetailsEntity;

public interface HotelRoomDetailsRepository extends JpaRepository<HotelRoomDetailsEntity, Integer> {

}
