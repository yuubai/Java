package com.example.second.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "InformCountDao")
public interface InformCountDao {

    public void addCount(Integer count);

}
