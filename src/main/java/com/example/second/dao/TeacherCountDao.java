package com.example.second.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "TeacherCountDao")
public interface TeacherCountDao {

    public void addCount(Integer count);

}
