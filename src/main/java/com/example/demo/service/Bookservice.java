package com.example.demo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.BookDao;
import com.example.demo.bean.Book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
@Component
public class Bookservice {
    public  ApplicationContext context;

    @Autowired
    private BookDao bookDao;


    @Autowired
    private Book book;



    private static Bookservice bookservice;

    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        bookservice = this;
    }


    @Before
    public void before(){
        System.out.println ("CRUD");
    }
    @After
    public void after(){
        System.out.println ("CRUD");
    }


    //返回book实例
    public  Book getBook(){
        return  bookservice.book;
    }





    //修改书籍
    public  void update(Book book){
        bookservice.bookDao.update(book);
    }


    //依据书名查找书籍
    public  List<Book> selectByname(Book book){
        List<Book>  bookList = bookservice.bookDao.selectByName (book);
        return bookList;
    }
    //依据作者查找书籍
    public  List<Book> selectByauthor(Book book){
        List<Book>  bookList = bookservice.bookDao.selectByauthor (book);
        return bookList;
    }

    
    //动态sql查询书籍
    public  List<Book> selectBy(Book book){
        List<Book>  bookList = bookservice.bookDao.selectBy (book);
        return bookList;
    }


    //动态sql删除书籍
    public  void delete(Book book){
        bookservice.bookDao.delete (book);
    }

    //点击量记录
    public  void pontchange(int id){
        bookservice.book.setId (id);
        bookservice.bookDao.pontchange (bookservice.book);
    }



    @Test
    public  void test(){
        init();
        bookservice.book.setId (63);
        bookservice.bookDao.pontchange (bookservice.book);
    }
}
