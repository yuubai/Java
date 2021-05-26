package com.example.second.service.impl;



import com.example.second.entity.InformCount;

import com.example.second.service.InformCountService;
import org.springframework.stereotype.Service;

@Service
public class InformCountServiceBean implements InformCountService {
    public void addCount(InformCount informCount) {
        Integer count = informCount.getCount();

    }

    public void reduceCount(InformCount informCount) {
        Integer count = informCount.getCount();

    }
}
