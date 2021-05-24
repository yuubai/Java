package com.example.second.service;

import com.example.second.entity.CourseCount;

public interface CourseCountService {
    public void addCount(CourseCount courseCount);

    public void reduceCount(CourseCount courseCount);
}
