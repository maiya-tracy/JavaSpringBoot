package com.maiya.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiya.mvc.models.Book;
import com.maiya.mvc.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository br;
    
    // returns all the books
    public List<Book> allBooks() {
        return br.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return br.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = br.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book currentBook = br.findById(id).get();
		currentBook.setTitle(title);
		currentBook.setDescription(desc);
		currentBook.setLanguage(lang);
		currentBook.setNumberOfPages(numOfPages);
		br.save(currentBook);
		return currentBook;
	}
	public void deleteBook(Long id) {
		br.deleteById(id);
	}
}
