package cm.bookstore.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cm.bookstore.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
