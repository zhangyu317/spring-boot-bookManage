package com.zhangyu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhangyu.entity.JPABook;

public interface JPABookRepository extends JpaRepository<JPABook, Long> {

}
