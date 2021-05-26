package com.example.second.service;

import com.example.second.entity.Inform;

import java.util.List;

public interface InformService {

    public List<Inform> findAllInforms();

    public void addInform(Inform inform);

    public void deleteInformById(Long uid);

    public void updateInform(Inform inform);

    List<Inform> findInformByName(String name);

    public Integer deleteInformsByIds(Integer[] ids);
}
