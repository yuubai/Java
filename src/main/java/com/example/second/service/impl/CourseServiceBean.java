package com.example.second.service.impl;

import com.example.second.dao.CourseCopyDao;
import com.example.second.dao.CourseCountDao;
import com.example.second.dao.CourseDao;
import com.example.second.entity.Course;
import com.example.second.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
//@Transactional(rollbackFor = Exception.class)
public class CourseServiceBean implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseCountDao courseCountDao;

    @Autowired
    CourseCopyDao courseCopyDao;

    public List<Course> findAllCourses() {
        return this.courseDao.findAllCourses();
    }


    @Transactional
    public void addCourse(Course course) {
        this.courseDao.addCourse(course);
//        this.courseCopyDao.addCourse(course);
        Integer count = this.courseDao.getCountCourses();
        //没有加@Transactional注解，万一出现错误，新增人数会成功，但是学生表的总人数没有改变，出现了数据的不一致。
        //int x = 5 / 0;
        this.courseCountDao.addCount(count);
    }

    public void deleteCourseById(Long cid) {
        this.courseDao.deleteCourseById(cid);
        Integer count = this.courseDao.getCountCourses();
        this.courseCountDao.addCount(count);
    }

    public void updateCourse(Course course) {
        this.courseDao.updateCourse(course);
    }

    public List<Course> findCourseByName(String name) {
        return this.courseDao.findCourseByName(name);
    }

    public Integer deleteCoursesByIds(Integer[] ids) {
        return this.courseDao.deleteCoursesByIds(ids);
    }

}
