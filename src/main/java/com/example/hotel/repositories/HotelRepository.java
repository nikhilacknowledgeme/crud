package com.example.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.entities.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

}
