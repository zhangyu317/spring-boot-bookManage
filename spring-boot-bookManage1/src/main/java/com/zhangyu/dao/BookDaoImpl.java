package com.zhangyu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zhangyu.entity.Book;

@Repository
public class BookDaoImpl implements IBookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() {
        String sql = "SELECT id,name,writer,introduction FROM t_book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Book.class));
    }

    @Override
    public Book insertByBook(Book book) {
        String sql = "INSERT INTO t_book(name,writer,introduction) VALUES(?,?,?)";
        jdbcTemplate.update(sql, book.getName(),book.getWriter(), book.getIntroduction());
        return book;
    }

    @Override
    public Book update(Book book) {
        String sql = "UPDATE t_book SET name=?,writer=?,introduction=? WHERE id=?";
        int i = jdbcTemplate.update(sql, book.getName(), book.getWriter(),
                book.getIntroduction(), book.getId());
        System.out.println("更新书本的id是：" + book.getId());
        return book;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM t_book WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Book findById(Long id) {
        String sql = "SELECT id,name,writer,introduction FROM t_book WHERE id=?";
        return (Book) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Book.class));
    }
}