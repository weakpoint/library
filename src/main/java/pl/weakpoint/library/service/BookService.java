package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import pl.weakpoint.library.model.Book;

public interface BookService {
	List<Book> getAllBooks();

	Optional<Book> getBookByIsbn(String isbn);
}
