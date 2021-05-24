package com.example.second.dao;


import com.example.second.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "CourseCopyDao")
public interface CourseCopyDao {

    int addCourse(Course courseCopy);

}
