package backend.bookstore;

import org.springframework.data.repository.CrudRepository;

import backend.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByCategoryId(Long categoryId);
    
}
