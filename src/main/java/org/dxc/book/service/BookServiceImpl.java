package org.dxc.book.service;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
		
	}

	@Override
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

	

	@Override
	public Optional<Book> getBook(int bid) {
			return bookRepository.findById(bid);
	}

	@Override
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
		
	}

	@Override
	public void updateBook(Book book,Integer bid) {
		 Book updateBook=bookRepository.findById(bid).get();
		 updateBook.setBookName(book.getBookName());
		 updateBook.setAuthorName(book.getAuthorName());
		 updateBook.setPublisher(book.getPublisher());
		 updateBook.setIsbn(book.getIsbn());
		 updateBook.setCategory(book.getCategory());
		 updateBook.setPrice(book.getPrice());
		 bookRepository.save(updateBook);
	}
	
	@Override
	public List<Book> findByPublisher(String publisher){
		return bookRepository.findByPublisher(publisher);
	}

	@Override
	public List<Book> findByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthor(authorName);
	}

	@Override
	public List<Book> findByCategory(String category) {
		// TODO Auto-generated method stub
		return bookRepository.findByCategory(category);
	}
	
}
