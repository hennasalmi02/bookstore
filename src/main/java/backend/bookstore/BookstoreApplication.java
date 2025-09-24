package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepo, CategoryRepository catRepo) {
    return (args) -> {
        Category fantasy = catRepo.save(new Category(4L, "Fantasy"));
        Category scifi   = catRepo.save(new Category(1L, "Sci-Fi"));
        Category romance = catRepo.save(new Category(2L, "Romance"));

        bookRepo.save(new Book("978-0261103344", "The Hobbit", "J.R.R. Tolkien", 1937, 15.99, fantasy));
        bookRepo.save(new Book("978-0553386790", "Dune", "Frank Herbert", 1965, 18.99, scifi));
        bookRepo.save(new Book("978-0141439600", "Pride and Prejudice", "Jane Austen", 1813, 12.99, romance));

        bookRepo.findAll().forEach(System.out::println);
    };
}

}
