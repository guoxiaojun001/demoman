package com.example.demoman.services;

import com.example.demoman.jpaservices.ManRepository;
import com.example.demoman.module.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * 测试事物
 */
@Service
public class TestTransactionService {

    @Autowired
    private ManRepository manRepository;

    @Transactional
    public void insertMultMan(){
        Man man1 = new Man();
        man1.setCupSize("H");
        man1.setAge(33);
        manRepository.save(man1);

        Man man2 = new Man();
        man2.setCupSize("HB");
        man2.setAge(33);
        manRepository.save(man2);
    }
}
