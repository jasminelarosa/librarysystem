package com.larosa.librarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "books")
public class BookController {

    @GetMapping(value = "addbook")
    public ModelMap addbook() {
        return new ModelMap();
    }

    @GetMapping(value = "logbook")
    public ModelMap logbook() {
        return new ModelMap();
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

    @GetMapping(value = "registration")
    public ModelMap registration() {
        return new ModelMap();
    }

    @GetMapping(value = "bookstatus")
    public ModelMap bookstatus() {
        return new ModelMap();
    }




}