package com.controller;

import com.exception.MyException;
import com.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

@Controller//这个得加
public class DemoController {
    //为什么这里可以不加
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/show5")
    public String show5() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        demoService.show5();
        return "index";
    }

    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        demoService.show1();
        //demoService.show2();
        //demoService.show3();
        //demoService.show4();
//        demoService.show5();
        return "index";
    }

}
