package pl.weakpoint.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.weakpoint.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
