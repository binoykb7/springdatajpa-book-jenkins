package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.springframework.data.repository.query.Param;

public interface BookService {
	
	public Book saveBook(Book book);
	public void updateBook(Book book,Integer bid);
	public List<Book> findAll();
	public Optional<Book> getBook(int bid);
	public void deleteBook(int bid);
	
	public List<Book> findByPublisher(String publisher);
	public List<Book> findByAuthor(String authorName);
	public List<Book> findByCategory(String category);

}
