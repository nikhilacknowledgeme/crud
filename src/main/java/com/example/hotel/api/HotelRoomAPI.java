package com.example.hotel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Hotel;
import com.example.hotel.model.HotelRoomDetails;
import com.example.hotel.service.HotelService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class HotelRoomAPI {
	@Autowired
	HotelService hotelService;
	
	//@CrossOrigin
	@GetMapping("/hotel/{id}")
	@ApiOperation(value = "It returns the details about a specific hotel")
	@ApiResponses( {
	     @ApiResponse(code = 200, message = "The request is processed by the server and the response is successfully generated."),
	     @ApiResponse(code = 404, message = "The request url path doesn't exist in server application")
	})
	public ResponseEntity<Hotel> getHotelDetails(@ApiParam(value="The hotel id")@PathVariable Integer id) {
		Hotel hotel = hotelService.fetchHotelDetailsById(id);
		return ResponseEntity.ok(hotel);
	}
	
	@PostMapping("/hotel/add")
	public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
		String message = hotelService.addHotelDetails(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@GetMapping("/room/{id}")
	public ResponseEntity<HotelRoomDetails> getHotelRoomDetails(@PathVariable Integer id) {
		HotelRoomDetails roomDetails = hotelService.fetchHotelRoomDetailsById(id);
		return ResponseEntity.ok(roomDetails);
	}
	
	@DeleteMapping("/room/delete/{id}")
	public ResponseEntity<Void> deleteRoomDetails(Integer id) {
		hotelService.deleteRoomDetailsById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
