package pl.weakpoint.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Book;
import pl.weakpoint.library.repository.BookRepository;
import pl.weakpoint.library.service.BookService;

@RestController
public class BookController {
	private BookService bookService;
	
	@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	
	@RequestMapping(BookRequestMapping.BOOK_ROOT)
	public List<Book> getAllBooks(){
		return null;//bookService.findAll();
	}
}