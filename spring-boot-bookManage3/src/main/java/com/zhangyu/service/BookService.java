package com.zhangyu.service;

import java.util.List;

import com.zhangyu.pojo.Book;

public interface BookService {
    /**
     * 获取所有 Book
     */
	List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    int insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    int update(Book book);

    /**
     * 删除 Book
     *
     * @param id 编号
     */
    void delete(Long id);

    /**
     * 获取 Book
     *
     * @param id 编号
     */
    Book findById(Long id);
}