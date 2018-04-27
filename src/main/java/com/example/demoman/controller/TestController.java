package com.example.demoman.controller;

import com.example.demoman.jpaservices.ManRepository;
import com.example.demoman.module.Man;
import com.example.demoman.ymlprop.ManProperity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/TTT")
public class TestController {

    @Value("${test.data1}")
    private String data1;

    @Value("${content}")
    private String data;

    @Autowired
    private ManProperity man;


    //直接返回yml中的属性
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return data1;
    }

    //yml配置中引用yml配置属性,请求方式默认不写的话，post 和get都支持
    @RequestMapping(value = "/testyml")
    public String testyml(){
        return data;
    }


    //对象形式的引用，yml中对象整体注入, 如果多个路径返回同一个数据，可以用数组
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String ymlObj(){
        return man.toString();
    }


    //路径中带有参数
    @RequestMapping(value = "/param/{id}")
    public String getParam(@PathVariable(value ="id",required = true) Integer myId){
        return "id = " + myId;
    }


    //获取路径中 的参数  http://localhost:8080/demo/TTT/param?id=3
    //@RequestMapping(value = "/getparam",method = RequestMethod.GET) = @GetMapping(value = "/getparam")
    @GetMapping(value = "/getparam")
    /* 此id 需要与路径保持中的参数名称一致 */
    public String testParam(@RequestParam(value = "id",required = false , defaultValue = "0")
                                        Integer id/* 这个id可以随便写*/){
        return "id = " + id;
    }

}
