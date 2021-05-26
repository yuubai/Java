package com.example.second.service;

import com.example.second.entity.InformCount;

public interface InformCountService {
    public void addCount(InformCount informCount);

    public void reduceCount(InformCount informCount);
}