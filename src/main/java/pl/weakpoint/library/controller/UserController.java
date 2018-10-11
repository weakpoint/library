package pl.weakpoint.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.User;
import pl.weakpoint.library.service.UserService;

@RestController
@RequestMapping(UserRequestMapping.USER_ROOT)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = UserRequestMapping.GET_ALL, method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable(value="id") String id){
		return userService.getUserById(id);
	}
}
