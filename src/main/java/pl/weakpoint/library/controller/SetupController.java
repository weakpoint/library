package pl.weakpoint.library.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Author;
import pl.weakpoint.library.model.Book;
import pl.weakpoint.library.model.Reservation;
import pl.weakpoint.library.model.User;
import pl.weakpoint.library.repository.AuthorRepository;
import pl.weakpoint.library.repository.BookRepository;
import pl.weakpoint.library.repository.ReservationRepository;
import pl.weakpoint.library.repository.UserRepository;

@RestController
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
	
	@RequestMapping("/init")
	public String setupDB(){
//		Book book = bookRepository.getOne("00001");
//		if (book != null) {
//			return "juuu";
//		}
		List<User> users = setupUsers();
		List<Author> authors = setupAuthors();
		List<Book> books = setupBooks(authors);
		setupReservations(users, books);
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
		List<Author> authors = new ArrayList<>();
		authors.add(createAuthor("Author1","LastAuthor1"));
		authors.add(createAuthor("Author2","LastAuthor2"));
		authors.add(createAuthor("Author3","LastAuthor3"));
		authors.add(createAuthor("Author4","LastAuthor4"));
		authors.add(createAuthor("Author5","LastAuthor5"));
		authors = authorRepository.saveAll(authors);
		return authors;
	}

	private List<Book> setupBooks(List<Author> authors) {
		List<Book> books = new ArrayList<>();
		books.add(createBook("00001", "BookName1", authors.get(0)));
		books.add(createBook("00002", "BookName1a", authors.get(0)));
		
		books.add(createBook("00003", "BookName2", authors.get(1)));
		books.add(createBook("00004", "BookName2a", authors.get(1)));
		
		books.add(createBook("00005", "BookName3a", authors.get(2)));
		
		books.add(createBook("00006", "BookName4a", authors.get(3)));
		
		books.add(createBook("00007", "BookName5a", authors.get(4)));
		books = bookRepository.saveAll(books);
		return books;
	}

	private List<Reservation> setupReservations(List<User> users, List<Book> books) {
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(createReservation(users.get(0), books.get(0), books.get(1)));
		reservations.add(createReservation(users.get(0), books.get(4)));
		reservations.add(createReservation(users.get(1), books.get(3)));
		reservations.add(createReservation(users.get(2), books.get(0), books.get(1)));
		
		reservations = reservationRepository.saveAll(reservations);
		return reservations;
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
	
	private Author createAuthor(String firstName, String lastName){
		Author author = new Author();
		author.setName(firstName);
		author.setLastName(lastName);
		return author;
	}
	
	private Book createBook(String isbn, String name, Author author){
		Book book = new Book();
		book.setIsbn(isbn);
		book.setName(name);
		book.setAuthors(new ArrayList<>(Arrays.asList(author)));
		return book;
	}
	
	private Reservation createReservation(User owner, Book... books){
		Reservation reservation = new Reservation();
		reservation.setOwner(owner);
		reservation.setBooks(new ArrayList<>(Arrays.asList(books)));
		return reservation;
	}

}
