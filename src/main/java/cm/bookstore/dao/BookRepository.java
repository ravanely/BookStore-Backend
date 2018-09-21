package cm.bookstore.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cm.bookstore.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByTitleContaining(String keyword);
}
