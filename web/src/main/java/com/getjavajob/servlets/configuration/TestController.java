package com.getjavajob.servlets.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/test/")
public class TestController {

    @RequestMapping(value = "log")
    public void test() {
        System.out.println("just log");
    }

    @RequestMapping(value = "loglog")
    public void test2() {
        System.out.println("log log ");
    }

    @RequestMapping(value = "/logloglog")
    public void test3() {
        System.out.println("log log ");
    }

    @RequestMapping(value = "/req")
    public void test4(HttpServletRequest request, HttpSession session) {
        System.out.println(session.getId());
        System.out.println("request");
    }
}
