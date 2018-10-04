package pl.weakpoint.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.weakpoint.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
