package com.example.demoman.controller;

import com.example.demoman.aspect.HttpAspect2;
import com.example.demoman.errorenum.ErrorCodeEnum;
import com.example.demoman.exception.MyException;
import com.example.demoman.jpaservices.ManRepository;
import com.example.demoman.module.Man;
import com.example.demoman.module.ReturnResult;
import com.example.demoman.services.ManService;
import com.example.demoman.services.TestTransactionService;
import com.example.demoman.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController
public class ManController {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect2.class);

    @Autowired
    private ManRepository manRepository;

    @Autowired
    private TestTransactionService testTransactionService;

    @Autowired
    private ManService manService;

    @GetMapping(value = "/manlist")
    public List<Man> getManList(){

        List<Man>  list = manRepository.findAll();
        logger.info("list = " + list);
        return list;
    }


    //@PostMapping(value = "/addaMan")
    @PostMapping(path = "addaMan")
    public ReturnResult<Man> addMan(@Validated @RequestBody  Man man , BindingResult bindingResult){
        ReturnResult returnResult = new ReturnResult();
        if(bindingResult.hasErrors()){
            return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        logger.info("man = " + man);
        return ResultUtils.success(manRepository.save(man));
    }


    @PostMapping(value = "/add")
    public Man add(@RequestParam("cupSize") String cupSize , @RequestParam("age") Integer age){

        Man man = new Man();
        man.setAge(age);
        man.setCupSize(cupSize);

        return  manRepository.save(man);
    }


    @GetMapping(value = "/getOneMan/{id}")
    public Man getOneMan(@PathVariable(value ="id")  Integer id){
        Man man = manRepository.findById(id).get();
        return man;
    }


    @PostMapping(value = "/update")
    public Man updateMan(@RequestBody  Man man){

       logger.info("man = " + man);
        return   manRepository.saveAndFlush(man);
    }

    @PutMapping(value = "/updateput")
    public Man updatePutMan(@RequestBody  Man man){

       logger.info("man = " + man);
        return   manRepository.saveAndFlush(man);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteMan(@PathVariable("id") Integer id){

       logger.info("id = " + id);
        manRepository.deleteById(id);
        return "OK";
    }


    //自定义查询
    @GetMapping("/men/age/{id}")
    public List<Man> getbyAge(@PathVariable("id") Integer age)  {

        return manService.findByAge(age);
    }


    //测试事物
    @PostMapping("/men/insermult")
    public void insertMultMan(){
         testTransactionService.insertMultMan();
    }


    /**
     * 测试全局异常捕获
     * @param code
     */
    @RequestMapping("/exception/{code}")
    public void testException(@PathVariable Integer code)  {
        if(code == 0){
            throw new MyException(ErrorCodeEnum.ERROR_100);
        }

        if(code == 1){
            throw new MyException(ErrorCodeEnum.ERROR_200);
        }

        if(code == 2){
            throw new MyException(ErrorCodeEnum.UNKONW_ERROR);
        }else {
            int a = 1/0;
        }
    }

}
