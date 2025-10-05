package backend.bookstore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backend.bookstore.domain.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
