package com.example.second.service.impl;


import com.example.second.entity.TeacherCount;
import com.example.second.service.TeacherCountService;
import org.springframework.stereotype.Service;

@Service
public class TeacherCountServiceBean implements TeacherCountService {
    public void addCount(TeacherCount teacherCount) {
        Integer count = teacherCount.getCount();

    }

    public void reduceCount(TeacherCount teacherCount) {
        Integer count = teacherCount.getCount();

    }
}
