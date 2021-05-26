package com.example.second.service.impl;

import com.example.second.dao.InformCopyDao;
import com.example.second.dao.InformCountDao;

import com.example.second.dao.InformDao;
import com.example.second.entity.Inform;
import com.example.second.service.InformService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
//@Transactional(rollbackFor = Exception.class)
public class InformServiceBean implements InformService {

    @Autowired
    private InformDao informDao;

    @Autowired
    private InformCountDao informCountDao;

    @Autowired
    InformCopyDao informCopyDao;

    public List<Inform> findAllInforms() {
        return this.informDao.findAllInforms();
    }


    @Transactional
    public void addInform(Inform inform) {
        this.informDao.addInform(inform);
//        this.informCopyDao.addInform(inform);
        Integer count = this.informDao.getCountInforms();
        //没有加@Transactional注解，万一出现错误，新增人数会成功，但是学生表的总人数没有改变，出现了数据的不一致。
        //int x = 5 / 0;
        this.informCountDao.addCount(count);
    }

    public void deleteInformById(Long uid) {
        this.informDao.deleteInformById(uid);
        Integer count = this.informDao.getCountInforms();
        this.informCountDao.addCount(count);
    }

    public void updateInform(Inform inform) {
        this.informDao.updateInform(inform);
    }

    public List<Inform> findInformByName(String name) {
        return this.informDao.findInformByName(name);
    }

    public Integer deleteInformsByIds(Integer[] ids) {
        return this.informDao.deleteInformsByIds(ids);
    }

}
