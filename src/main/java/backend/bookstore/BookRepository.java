package backend.bookstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import backend.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, String> {

	List<Book> deleteByIsbn(String isbn);
	
	List<Book> findByIsbn(String isbn);
}