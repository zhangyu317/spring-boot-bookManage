package com.zhangyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class JPABook implements Serializable {
    private static final long serialVersionUID = 3537921742065870581L;
    
    /**
     * 空参构造
     */
    public JPABook() {
    }
    /**
     * 有参构造
     */
    public JPABook(String name, String writer, String introduction) {
        this.name = name;
        this.writer = writer;
        this.introduction = introduction;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //(strategy = GenerationType.AUTO) ==>>  mysql不支持，oracle支持

    /**
     * 书名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 作者
     */
    @Column(nullable = false)
    private String writer;

    /**
     * 简介
     */
    @Column(nullable = false)
    private String introduction;
    
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
