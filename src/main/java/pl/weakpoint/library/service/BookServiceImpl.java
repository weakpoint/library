package pl.weakpoint.library.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pl.weakpoint.library.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	
}
