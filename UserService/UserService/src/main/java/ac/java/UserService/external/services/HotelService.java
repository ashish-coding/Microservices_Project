package ac.java.UserService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ac.java.UserService.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public class HotelService {
//	
//	@GetMapping("/hotels/{hotelId}")
//	public Hotel getHotel(@PathVariable("hotelId") int hotelId);
}
