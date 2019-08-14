package com.maiya.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maiya.mvc.models.Book;
import com.maiya.mvc.services.BookService;

@Controller
public class BooksController {
	@Autowired
	BookService bs;

//	******************
//	show all books
//	******************
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bs.allBooks();
		model.addAttribute("books", books);
		return "/WEB-INF/books/index.jsp";
	}

//	******************
//	show one book
//	******************
	@RequestMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Book book = bs.findBook(id);
		model.addAttribute("book", book);
		return "/WEB-INF/books/show.jsp";
	}

//	******************
//	add book
//	******************
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/WEB-INF/books/new.jsp";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/books/new.jsp";
		} else {
			bs.createBook(book);
			return "redirect:/books";
		}
	}

//	******************
//    edit book
//	******************
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bs.findBook(id);
		model.addAttribute("book", book);
		return "/WEB-INF/books/edit.jsp";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/WEB-INF/books/edit.jsp";
		} else {
			bs.updateBook(id, book);
			return "redirect:/books";
		}
	}

//	******************
//    delete book
//	******************
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bs.deleteBook(id);
		return "redirect:/books";
	}
}
