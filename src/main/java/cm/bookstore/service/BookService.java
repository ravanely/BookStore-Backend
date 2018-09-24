package cm.bookstore.service;

import java.util.List;

import cm.bookstore.entities.Book;

public interface BookService {
	
	List<Book> findAll();
	
	Book findOne(Long id);
	
	Book save(Book book);
	
	List<Book> blurrySearch(String title);
	
	void removeOne(Long id);
}
