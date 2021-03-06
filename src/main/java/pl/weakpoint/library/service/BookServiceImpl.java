package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.weakpoint.library.model.Book;
import pl.weakpoint.library.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@Override
	public Optional<Book> getBookByIsbn(String isbn) {
		return bookRepository.findById(isbn);
		
	}
}
