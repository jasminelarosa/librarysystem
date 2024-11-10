package com.larosa.librarysystem.controller;

import com.larosa.librarysystem.entity.Book;
import com.larosa.librarysystem.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "Library")
@AllArgsConstructor
public class BookController {
    private final BookRepository bookRepository;


    @PostMapping(value = "addBook")
    public String newBook(Book book, Model model) {
        if (bookRepository.findByBookId(book.getBookId()) != null) {
            model.addAttribute("bookExist", true);
            model.addAttribute("book", book);
        }else{
            model.addAttribute("book", new Book());
            model.addAttribute("bookAdded", true);
            bookRepository.save(book);
        }
        return "/Library/addBook";
    }

    @GetMapping(value = "addBook")
    public String getBook(Model model) {
       Book book = new Book();
        model.addAttribute("book", book);
        return "Library/addBook";
    }

    @GetMapping(value = "bookstatus")
    public String bookStatus( Model model) {
        List<Book> book = bookRepository.findAllBook();
        model.addAttribute("books", book );
        return "Library/bookstatus";

    }

    @GetMapping(value = "borrowing")
    public ModelMap borrowing() {
        return new ModelMap();
    }
    @GetMapping(value = "computer")
    public ModelMap computer() {
        return new ModelMap();
    }
    @GetMapping(value = "reservation")
    public ModelMap reservation() {
        return new ModelMap();
    }



}