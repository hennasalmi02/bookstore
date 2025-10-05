package backend.bookstore.web;

import backend.bookstore.BookRepository;
import backend.bookstore.CategoryRepository;
import backend.bookstore.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository crepository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/booklist")
    public String showIndex(Model model, Authentication authentication) {
        model.addAttribute("books", repository.findAll());
        model.addAttribute("roles", authentication.getAuthorities());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("isbn") String isbn, Model model) {
	    repository.deleteByIsbn(isbn);
	    return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/edit/{isbn}", method = RequestMethod.GET)
    public String updateBook(@PathVariable("isbn") String isbn, Model model) {
	    Book book = repository.findByIsbn(isbn);
        model.addAttribute("book", book);
        model.addAttribute("categories", crepository.findAll());
	    return "editbook";
    }

}
