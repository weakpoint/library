package pl.weakpoint.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.User;
import pl.weakpoint.library.service.UserService;

@RestController
@RequestMapping(UserRequestMapping.USER_ROOT)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@RequestMapping("/{name}")
	public void addUser(@PathVariable(value="name") String name){
		userService.createUser(name);
	}
}
