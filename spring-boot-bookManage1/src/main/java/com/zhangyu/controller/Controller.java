package com.zhangyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {
	@RequestMapping("/hello")
	public String printHello() {
		/*User u = new User();
		u.setName("MaiZi");
		u.setAge(5);
		u.setBirthday(new Date());
		u.setPassword("MaiZi");
		u.setDesc("hello!");*/
		return "hello world!";
	}
}
