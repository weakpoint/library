package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.weakpoint.library.model.User;
import pl.weakpoint.library.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void createUser(String name) {
		User user = new User();
		user.setFirstName(name);
		user.setLastName(name);
		user.setEmail(name+"@"+name+".pl");
		user.setPhone("510 510 510");
		userRepository.save(user);
		
	}


	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public Optional<User> getUserById(String id) {
		return userRepository.findById(Long.parseLong(id));
		
	}

}
