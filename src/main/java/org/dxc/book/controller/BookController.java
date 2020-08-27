package org.dxc.book.controller;

import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.dxc.book.repository.BookRepository;
import org.dxc.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/savebook" , method=RequestMethod.POST)
	public HttpStatus saveBook(@RequestBody Book book) {
		boolean status=bookService.saveBook(book)!=null;
		return status?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Book> findAll() {
		return bookService.findAll();		
	}
	
	@RequestMapping(value="/deletebook",method=RequestMethod.DELETE)
	public void deleteBook(@RequestParam("bookId")int bid) {
		bookService.deleteBook(bid);
	}
	@RequestMapping(value="/getbook", method=RequestMethod.GET)
	public Optional<Book> getBook(@RequestParam("bookId")int bid){
		return bookService.getBook(bid);
	}
	@RequestMapping(value="/updatebook",method=RequestMethod.PUT)
	public void updateBook(@RequestBody Book book,@RequestParam("bookId") Integer bid) {
		bookService.updateBook(book, bid);
	}
	
	@RequestMapping(value="/findbypublisher", method=RequestMethod.GET)
	public List<Book> fetchDataByPublisher(@RequestParam("publisher")String publisher){
		return bookService.findByPublisher(publisher);
	}
	@RequestMapping(value="/findbyauthor", method=RequestMethod.GET)
	public List<Book> fetchDataByAuthor(@RequestParam("authorName")String authorName){
		return bookService.findByAuthor(authorName);
	}
	@RequestMapping(value="/findbycategory", method=RequestMethod.GET)
	public List<Book> fetchDataByCategory(@RequestParam("category")String category){
		return bookService.findByCategory(category);
	}
}
