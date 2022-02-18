package com.example.demo;

import com.example.demo.bean.Book;
import com.example.demo.service.Bookservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    Bookservice bookservice;

    @Test
    public void contextLoads() {
        Book book = bookservice.getBook();
        System.out.println("该用户ID为：");
        System.out.println(book);
    }

}