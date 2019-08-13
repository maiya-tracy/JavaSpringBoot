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
import org.springframework.web.bind.annotation.RequestParam;

import com.maiya.mvc.models.Book;
import com.maiya.mvc.services.BookService;

@Controller
public class BooksController {
	@Autowired
	BookService bs;

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bs.allBooks();
		model.addAttribute("books", books);
		return "/WEB-INF/books/index.jsp";
	}
	@RequestMapping("/books/{id}")
	public String show(Model model, @PathVariable ("id") Long id) {
//		Long longID = (Long) id;
		Book book = bs.findBook(id);
		model.addAttribute("book", book);
		return "/WEB-INF/books/show.jsp";
	}
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/WEB-INF/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/WEB-INF/books/new.jsp";
        } else {
            bs.createBook(book);
            return "redirect:/books";
        }
    }
}
