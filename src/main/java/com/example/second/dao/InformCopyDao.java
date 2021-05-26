package com.example.second.dao;
import com.example.second.entity.Inform;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "InformCopyDao")
public interface InformCopyDao {

    int addInform(Inform informCopy);

}
