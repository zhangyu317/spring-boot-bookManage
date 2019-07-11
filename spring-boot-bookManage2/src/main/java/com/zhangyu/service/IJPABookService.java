package com.zhangyu.service;

import java.util.List;

import com.zhangyu.entity.JPABook;

public interface IJPABookService {
    /**
     * 获取所有 Book
     */
	List<JPABook> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link JPABook}
     */
    JPABook insertByBook(JPABook book);

    /**
     * 更新 Book
     *
     * @param book {@link JPABook}
     */
    JPABook update(JPABook book);

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
    JPABook findById(Long id);
}