package backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.bookstore.BookRepository;
import backend.bookstore.domain.Book;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class BookRestController {
    
    @Autowired
    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> findAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "isbn") String isbn) {
        return bookRepository.findById(isbn);
    }
}