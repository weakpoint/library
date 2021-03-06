package pl.weakpoint.library.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.weakpoint.library.model.Author;
import pl.weakpoint.library.model.User;
import pl.weakpoint.library.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(String id) {
		return authorRepository.findById(Long.parseLong(id));
	}
	
	
}
