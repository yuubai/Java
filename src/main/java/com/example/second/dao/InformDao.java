package com.example.second.dao;

import com.example.second.entity.Inform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "InformDao")
public interface InformDao {

    List<Inform> findAllInforms();

    int deleteInformById(Long uid);

    int insert(Inform inform);

    int addInform(Inform inform);

    Inform selectByPrimaryKey(Long uid);

    int updateInform(Inform inform);

    int updateByPrimaryKey(Inform inform);

    List<Inform> findInformByName(String name);

    Integer deleteInformsByIds(@Param("ids") Integer[] ids);

    int getCountInforms();
}
