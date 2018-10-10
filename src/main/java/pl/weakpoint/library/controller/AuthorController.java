package pl.weakpoint.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Author;
import pl.weakpoint.library.service.AuthorService;

@RestController
@RequestMapping(AuthorRequestMapping.AUTHOR_ROOT)
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
	
	@RequestMapping(AuthorRequestMapping.GET_ALL)
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
}
