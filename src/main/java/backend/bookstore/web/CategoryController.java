package backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.bookstore.CategoryRepository;
import backend.bookstore.domain.Category;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/categorylist")
    public String showList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist";
    }

    @RequestMapping(value = "/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String save(Category category) {
        repository.save(category);
        return "redirect:categorylist";
    }
}
