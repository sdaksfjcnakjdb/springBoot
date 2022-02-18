package com.example.demo.dao;

import com.example.demo.bean.Book;
import com.example.demo.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("BookDao")
public interface BookDao {

    public ArrayList<Book> selectAll(User user);

    public int  add(Book bean);

    public void update(Book bean);

    public void  delete(Book bean);

    public void pontchange(Book bean);

    public Book selectById(Book bean);

    public List<Book> selectByName(Book bean);

    public List<Book> selectByauthor(Book bean);


    public List<Book> selectBy(Book bean);
}
