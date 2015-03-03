package com.xplore.web.service;

import com.xplore.web.dao.JiansheDao;
import com.xplore.web.domain.Jianshe;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by damen on 2014/12/20.
 */
@Service
@Transactional
public class JiansheService {

    @Autowired
    JiansheDao jiansheDao;

    public Jianshe getById(Integer id) {
        return jiansheDao.get(id);
    }

    public Page<Jianshe> pagedList(Page<Jianshe> page) {

        page.setResult(jiansheDao.pagedList(page).getResult());
        page.setTotalCount(jiansheDao.getTotalCount());

        return page;
    }

    public void save(Jianshe jianshe) {
        jiansheDao.save(jianshe);
    }

    public void del(Integer id) {
        jiansheDao.delete(id);
    }


    public List<Jianshe> recent(){

        return jiansheDao.getRecent(6);
    }


    public int getTotalCount() {
        return jiansheDao.getTotalCount();
    }

    public Jianshe getLeftSiblingById(Integer id) {
        return jiansheDao.getLeftSiblingByid(id);
    }
    public Jianshe getRightSiblingById(Integer id) {
        return jiansheDao.getRightSiblingByid(id);
    }
}
