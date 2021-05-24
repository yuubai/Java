package com.example.second.dao;


import com.example.second.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "TeacherCopyDao")
public interface TeacherCopyDao {

    int addTeacher(Teacher teacherCopy);

}
