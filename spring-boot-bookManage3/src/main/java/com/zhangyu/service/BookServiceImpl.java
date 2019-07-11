package com.zhangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyu.dao.IBookMapper;
import com.zhangyu.pojo.Book;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
    private IBookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public int insertByBook(Book book) {
       return bookMapper.insertByBook(book);
    }

    @Override
    public int update(Book book) {
        return bookMapper.update(book);
    }

    @Override
    public void delete(Long id) {
    	bookMapper.delete(id);
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.findById(id);
    }
}