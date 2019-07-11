package com.zhangyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyu.dao.JPABookRepository;
import com.zhangyu.entity.JPABook;

@Service
public class JPABookServiceImpl implements IJPABookService {

	@Autowired
    private JPABookRepository jpaBookRepository;

    @Override
    public List<JPABook> findAll() {
        return jpaBookRepository.findAll();
    }

    @Override
    public JPABook insertByBook(JPABook jpaBook) {
        return jpaBookRepository.save(jpaBook);
    }

    @Override
    public JPABook update(JPABook jpaBook) {
        return jpaBookRepository.save(jpaBook);
    }

    @Override
    public void delete(Long id) {
        jpaBookRepository.deleteById(id);
    }

    @Override
    public JPABook findById(Long id) {
        return jpaBookRepository.getOne(id);
    }
}