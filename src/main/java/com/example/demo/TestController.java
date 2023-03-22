package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
@ResponseBody
public class TestController {

    @Value("${mytest}")
    private String mytest;

    @Value("${mytest2}")
    private String mytest2;

    @Value("${myString1}")
    private String myString1;

    @Value("${myString2}")
    private String myString2;

    @Value("${myString3}")
    private String myString3;

    @Autowired
    private Student student;


    @PostConstruct
    private void postConstruct(){
        System.out.println(student);
//        System.out.println("mystring1"+myString1);
//        System.out.println("mystring2"+myString2);
//        System.out.println("mystring3"+myString3);
    }


    @RequestMapping("/hi")
    public String sayHi(String name){
        if(!StringUtils.hasLength(name)){
            name = "张三";
        }
        return "你是猪吗  "+name;
    }

    @RequestMapping("/getconf")
    public String getConfig(){
        return mytest+mytest2;
    }

}
