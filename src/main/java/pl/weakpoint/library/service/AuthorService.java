package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import pl.weakpoint.library.model.Author;

public interface AuthorService {
	List<Author> getAllAuthors();

	Optional<Author> getAuthorById(String id);
}
