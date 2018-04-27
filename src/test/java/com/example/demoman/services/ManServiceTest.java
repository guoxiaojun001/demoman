package com.example.demoman.services;

import com.example.demoman.module.Man;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * 对service 进行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManServiceTest {

    @Autowired
    private ManService manService;


    @Test
    public void findByAge() {
    }

    @Test
    public void findById() {
        Man man =manService.findById(2);
        Assert.assertEquals(new Integer(22),man.getAge());
    }
}