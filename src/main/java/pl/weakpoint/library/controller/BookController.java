package pl.weakpoint.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Book;
import pl.weakpoint.library.service.BookService;

@RestController
@RequestMapping(BookRequestMapping.BOOK_ROOT)
public class BookController {
	private BookService bookService;
	
	@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	
	@RequestMapping(BookRequestMapping.GET_ALL)
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Book> getBook(@PathVariable(value="id") String id){
		return bookService.getBookByIsbn(id);
	}
}
