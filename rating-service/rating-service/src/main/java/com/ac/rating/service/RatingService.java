package com.ac.rating.service;

import java.util.List;

import com.ac.rating.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);

	List<Rating> getAllRating();

	List<Rating> getRatingByUserId(int userId);

	List<Rating> getRatingByHotelId(int hotelId);

}
