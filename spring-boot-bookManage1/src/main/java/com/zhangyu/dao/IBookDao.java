package com.zhangyu.dao;

import java.util.List;

import com.zhangyu.entity.Book;

public interface IBookDao {
    /**
     * 查所有书
     * @return 所有的书本
     */
    List<Book> findAll();

    /**
     * 添加一本书
     * @return 返回添加的书本
     */
    Book insertByBook(Book book);

    /**
     * 更新书本信息
     * @param book 要更新的书
     * @return 跟新的书
     */
    Book update(Book book);

    /**
     * 根据id删除书本
     * @param id 要删除的书本的id
     * @return 删除的书本
     */
    void delete(Long id);

    /**
     * 根据id查找书本
     * @param id 要查找书本的id
     * @return 返回要查找的书本
     */
    Book findById(Long id);
}
