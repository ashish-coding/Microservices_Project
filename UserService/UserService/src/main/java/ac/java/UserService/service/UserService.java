package ac.java.UserService.service;

import java.util.List;

import ac.java.UserService.entity.User;

public interface UserService {

	User createUser(User user);

	List<User> getAllUsers();

	User getUser(Integer userId);

}
