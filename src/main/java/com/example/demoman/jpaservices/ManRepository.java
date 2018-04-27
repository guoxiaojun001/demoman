package com.example.demoman.jpaservices;

import com.example.demoman.module.Man;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 如果不需要自定义查询，用jpa默认的方法即可
 *
 * 如果需要扩展一些curd方法，需要自己添加
 */
public interface ManRepository extends JpaRepository<Man,Integer> {


    //自定义查询，通过年龄来查询
    public List<Man> findByAge(Integer id);



}
