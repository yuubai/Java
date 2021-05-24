package com.example.second.service;

import com.example.second.entity.TeacherCount;

public interface TeacherCountService {
    public void addCount(TeacherCount teacherCount);

    public void reduceCount(TeacherCount teacherCount);
}
