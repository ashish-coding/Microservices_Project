package com.ac.hotel_service.service;

import java.util.List;

import com.ac.hotel_service.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel getHotelById(int hotelId);

	
}
