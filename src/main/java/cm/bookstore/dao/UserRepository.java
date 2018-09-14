package cm.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.bookstore.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
	//List<User> findAll();
}
