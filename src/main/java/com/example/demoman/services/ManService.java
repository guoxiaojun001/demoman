package com.example.demoman.services;


import com.example.demoman.jpaservices.ManRepository;
import com.example.demoman.module.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑 放到service层
 */

@Service
@Component
public class ManService {

    @Autowired
    private ManRepository manRepository;

    public List<Man> findByAge(Integer age){
        return manRepository.findByAge(age);
    }


    public Man findById(Integer id){
        return manRepository.findById(id).get();
    }
}
