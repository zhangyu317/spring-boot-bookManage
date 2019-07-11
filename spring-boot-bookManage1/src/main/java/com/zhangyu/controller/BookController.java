package com.zhangyu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhangyu.entity.Book;
import com.zhangyu.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {
    private static final Log log = LogFactory.getLog(BookController.class);

    private static final String BOOK_FORM_PATH_NAME = "bookForm";
    private static final String BOOK_LIST_PATH_NAME = "bookList";
    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(ModelMap modelMap) {
        log.info("测试...");
        return "test";
    }
    /**
     * 获取数的列表
     * 处理"/book"的get请求，获取所有书的列表
     * @return 书的列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap modelMap) {
        log.info("展示书单方法运行...");
        modelMap.addAttribute("bookList", bookService.findAll());
        return BOOK_LIST_PATH_NAME;
    }

    /**
     * 获取创建book表单
     * @return book表单
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap modelMap) {
        log.info("跳转到列表...");
        modelMap.addAttribute("book", new Book());
        modelMap.addAttribute("action", "create");
        return BOOK_FORM_PATH_NAME;
    }
    /**
     * 创建book
     * 处理"/book/create"的post请求，用来新建book信息
     * 通过@ModelAttribute绑定表单实体参数，也通过@RequestParam传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@ModelAttribute Book book) {
        log.info("添加书本到列表中...");
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }
    /**
     * 获取更新Book表单
     * 处理"/book/update/{id}"的get请求，通过URL中的id来获取Book信息
     * URL中的id，通过@PathVariable
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable Long id, ModelMap modelmap) {
        log.info("更新方法运行...");
        log.info(bookService.findById(id));
        modelmap.addAttribute("book", bookService.findById(id));
        modelmap.addAttribute("action", "update");
        return BOOK_FORM_PATH_NAME;
    }
    /**
     * 更新book
     * 处理"/update"的PUT请求，用来更新Book的信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBook(@ModelAttribute Book book) {
        log.info("更新书本到列表中...");
        log.info(book);
        bookService.update(book);
        return REDIRECT_TO_BOOK_URL;
    }
    /**
     *删除book
     * 处理"/book/{id}"的get请求，用来删除book信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        log.info("删除书本...");
        bookService.delete(id);
        return REDIRECT_TO_BOOK_URL;
    }
}