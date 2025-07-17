package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Book;
import com.nt.service.IBookService;

@Controller
public class BookController {
	
	@Autowired
	private IBookService service;
	

    // 1️⃣ Show All Books
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "home"; // home.jsp
    }
    
 // 2️⃣ Show Add Book Form
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book(0, null, null, 0));
        return "addBook"; // addBook.jsp
    }
	
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        service.saveBook(book);
        return "redirect:/books/"; // Redirect to home
    }
}
