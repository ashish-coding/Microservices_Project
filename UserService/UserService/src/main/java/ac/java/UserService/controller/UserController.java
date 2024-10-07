package ac.java.UserService.controller;

import java.util.List;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.java.UserService.entity.User;
import ac.java.UserService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	
	/* This is controller class used to route the requests using API Gateway*/
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();		
	}
	
	//int retryCount=1;
	
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "hotelRatingBreaker", fallbackMethod = "hotelRatingFallback")
	//@Retry(name = "hotelRatingRetryServic", fallbackMethod = "hotelRatingFallback")
	//@RateLimiter(name = "hotelRatingRateLimiter",fallbackMethod = "hotelRatingFallback")
	public ResponseEntity<User> getSingleUSer(@PathVariable Integer userId) {
		
		//logger.info("Retry count : {}",retryCount);
		//retryCount++;
		
		return ResponseEntity.ok(userService.getUser(userId));
		
	}
	
	//creating fallback method for circuitBreaker 
	public ResponseEntity<User> hotelRatingFallback(Integer userId, Exception ex){
		logger.info("fallback is executed because service down : ", ex.getMessage());
		User user = new User();
		user.setEmail("dummy@gmail.com");
		user.setUserName("dummy");
		user.setAbout("this user is created because some service is down");
		user.setUserId(6655);
		return ResponseEntity.ok(user);
	}
}
