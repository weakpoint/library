package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import pl.weakpoint.library.model.User;

public interface UserService {

	void createUser(String name);

	List<User> getAllUsers();

	Optional<User> getUserById(String id);

}
