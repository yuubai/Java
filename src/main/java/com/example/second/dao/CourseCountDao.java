package com.example.second.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "CourseCountDao")
public interface CourseCountDao {

    public void addCount(Integer count);

}
