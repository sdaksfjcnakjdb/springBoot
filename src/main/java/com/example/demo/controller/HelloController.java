package com.example.demo.controller;


import com.example.demo.bean.Book;
import com.example.demo.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    Bookservice bookservice;

    @Autowired
    Book book;

    @RequestMapping("/index")
    public String sayHello(Model model){
        book.setId(63);
        Book book1 = bookservice.selectBy(book).get(0);
        model.addAttribute ("name",book1);
        return "index";
    }
}