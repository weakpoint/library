package pl.weakpoint.library.service;

import java.util.List;

import pl.weakpoint.library.model.User;

public interface UserService {

	void createUser(String name);

	List<User> getAllUsers();

	User getUserById(String id);

}
