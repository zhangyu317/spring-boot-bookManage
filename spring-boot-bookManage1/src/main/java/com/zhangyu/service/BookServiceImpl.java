package com.zhangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyu.dao.IBookDao;
import com.zhangyu.entity.Book;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        bookDao.insertByBook(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        bookDao.update(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id);
    }
}