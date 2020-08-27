package org.dxc.book.repository;

import java.util.List;

import org.dxc.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book,Integer> {

	//List<Book> findByPublisher(String publisher);
	//List<Book> findByAuthor(String authorName);
	//List<Book> findByCategory(String category);
	
	@Query("SELECT b FROM Book b WHERE b.publisher=:publisher")
	public List<Book> findByPublisher(@Param("publisher")String publisher);
	
	@Query("SELECT b FROM Book b WHERE b.authorName=:authorName")
	public List<Book> findByAuthor(@Param("authorName")String authorName);
	
	@Query("SELECT b FROM Book b WHERE b.category=:category")
	public List<Book> findByCategory(@Param("category")String category);
}
