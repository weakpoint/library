package pl.weakpoint.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.weakpoint.library.model.Author;
import pl.weakpoint.library.model.Book;
import pl.weakpoint.library.model.Reservation;
import pl.weakpoint.library.model.User;
import pl.weakpoint.library.repository.AuthorRepository;
import pl.weakpoint.library.repository.BookRepository;
import pl.weakpoint.library.repository.ReservationRepository;
import pl.weakpoint.library.repository.UserRepository;

@Controller
public class SetupController {
	
private BookRepository bookRepository;
private UserRepository userRepository;
private ReservationRepository reservationRepository;
private AuthorRepository authorRepository;
	
@Autowired
	public SetupController(BookRepository bookRepository, UserRepository userRepository, ReservationRepository reservationRepository,
		AuthorRepository authorRepository) {
	this.bookRepository = bookRepository;
	this.userRepository = userRepository;
	this.reservationRepository = reservationRepository;
	this.authorRepository = authorRepository;
}
	
	@RequestMapping("/")
	public String setupDB(){
		List<User> users = setupUsers();
		List<Author> authors = setupAuthors();
		List<Book> books = setupBooks();
		List<Reservation> reservations = setupReservations();
		return "index.html";
	}


	private List<User> setupUsers() {
		List<User> users = new ArrayList<>();
		users.add(createUser("1@weakpoint.pl", "One", "LastOne", "500-000-001"));
		users.add(createUser("2@weakpoint.pl", "Two", "LastTwo", "500-000-002"));
		users.add(createUser("3@weakpoint.pl", "Three", "LastThree", "500-000-003"));
		users.add(createUser("4@weakpoint.pl", "Four", "LastFour", "500-000-004"));
		users.add(createUser("5@weakpoint.pl", "Five", "LastFive", "500-000-005"));
		users = userRepository.saveAll(users);
		return users;
	}

	private List<Author> setupAuthors() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Book> setupBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Reservation> setupReservations() {
		// TODO Auto-generated method stub
		return null;
	}


	private User createUser(String email, String firstName, String lastName, String phone){
		User user = new User();
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhone(phone);
		user.setPassword("weakpoint");
		user.setDeleted(false);
		return user;
	}

}
