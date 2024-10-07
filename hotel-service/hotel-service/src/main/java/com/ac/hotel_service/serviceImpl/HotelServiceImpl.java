package com.ac.hotel_service.serviceImpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac.hotel_service.entity.Hotel;
import com.ac.hotel_service.exceptions.ResourceNotFoundException;
import com.ac.hotel_service.repository.HotelRepository;
import com.ac.hotel_service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		hotel.setHotelId(new Random().nextInt());
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found"));
	}
	
}
