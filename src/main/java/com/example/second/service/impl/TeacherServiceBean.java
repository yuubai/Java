package com.example.second.service.impl;

import com.example.second.dao.TeacherCopyDao;
import com.example.second.dao.TeacherCountDao;
import com.example.second.dao.TeacherDao;

import com.example.second.entity.Teacher;
import com.example.second.exception.ValidateException;
import com.example.second.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
//@Transactional(rollbackFor = Exception.class)
public class TeacherServiceBean implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private TeacherCountDao teacherCountDao;

    @Autowired
    TeacherCopyDao teacherCopyDao;

    public List<Teacher> findAllTeachers() {
        return this.teacherDao.findAllTeachers();
    }


public List<String> errors(Teacher teacher){
        List<String> errors =new ArrayList<>();
    if(teacher.getName().length()<2 || teacher.getName().length()>15){
        errors.add("来自后端校验：姓名在2-15个字符之间");
    }
    if(teacher.getAge()<25 || teacher.getAge()>65){
        errors.add("来自后端校验：教师年龄应在25--65岁之间");
    }
    if(teacher.getYear()>2021){
        System.out.println("年份不超过今年");
        errors.add("来自后端校验：年份不超过今年");
    }
    if(teacher.getHeight()>200){
        System.out.println("教师身高不超过200 cm");
        errors.add("来自后端校验：教师身高不超过200 cm");
    }
    if(teacher.getWeight()>100){
        System.out.println("教师体重不超过100kg");
        errors.add("来自后端校验：教师体重不超过100kg");
    }
    if(teacher.getTel().length() !=11){
        System.out.println("电话号码输入不合法");
        errors.add("来自后端校验：电话号码输入不合法");
    }
    return errors;
    }
    @Transactional
    public void addTeacher(Teacher teacher){
        if(errors(teacher).size()>0){
            throw new ValidateException("-1",errors(teacher).toString());
        }else {
            this.teacherDao.addTeacher(teacher);
        }

    }
//    public Response addTeacher(Teacher teacher) {
//        if(teacher.getName().length()<2 || teacher.getName().length()>15){
//            return new Response(false,"来自后端校验：姓名在2-15个字符之间");
//        }
//        if(teacher.getAge()<25 || teacher.getAge()>65){
//            System.out.println("教师年龄应在25--65岁之间");
//            return new Response(false,"来自后端校验：教师年龄应在25--65岁之间");
//        }
//        if(teacher.getYear()>2021){
//            System.out.println("年份不超过今年");
//            return new Response(false,"来自后端校验：年份不超过今年");
//        }
//        if(teacher.getHeight()>200){
//            System.out.println("教师身高不超过200 cm");
//            return new Response(false,"来自后端校验：教师身高不超过200 cm");
//        }
//        if(teacher.getWeight()>100){
//            System.out.println("教师体重不超过100kg");
//            return new Response(false,"来自后端校验：教师体重不超过100kg");
//        }
//        if(teacher.getTel().length() !=11){
//            System.out.println("电话号码输入不合法");
//            return new Response(false,"来自后端校验：电话号码输入不合法");
//        }
//
//        this.teacherDao.addTeacher(teacher);
////        this.studentCopyDao.addStudent(student);
//        Integer count = this.teacherDao.getCountTeachers();
//        //没有加@Transactional注解，万一出现错误，新增人数会成功，但是学生表的总人数没有改变，出现了数据的不一致。
//        //int x = 5 / 0;
//        this.teacherCountDao.addCount(count);
//        return new Response(true,"添加教师信息成功（后端）");
//    }

//    public Response addTeacher(Teacher teacher){
//        if(teacher.getName().length()<2 || teacher.getName().length()>15){
//            return new Response(false,"来自后端校验：姓名在2-15个字符之间");
//        }
//        if(teacher.getAge()<25 || teacher.getAge()>65){
//            System.out.println("教师年龄应在25--65岁之间");
//            return new Response(false,"来自后端校验：教师年龄应在25--65岁之间");
//        }
//        //this.teacherDao.addTeacher(teacher);
//        Integer count = this.teacherDao.getCountTeachers();
//        this.teacherCountDao.addCount(count);
//        return new Response(true,"添加教师成功");
//    }
    public void deleteTeacherById(Long uid) {
        this.teacherDao.deleteTeacherById(uid);
        Integer count = this.teacherDao.getCountTeachers();
        this.teacherCountDao.addCount(count);
    }

    public void updateTeacher(Teacher teacher) {
        this.teacherDao.updateTeacher(teacher);
    }

    public List<Teacher> findTeacherByName(String name) {
        return this.teacherDao.findTeacherByName(name);
    }

    public Integer deleteTeachersByIds(Integer[] ids) {
        return this.teacherDao.deleteTeachersByIds(ids);
    }

}
