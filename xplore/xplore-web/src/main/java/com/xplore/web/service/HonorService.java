package com.xplore.web.service;

import com.xplore.web.dao.HonorDao;
import com.xplore.web.domain.Honor;
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
public class HonorService {

    @Autowired
    HonorDao honorDao;

    public Honor getById(Integer id) {
        return honorDao.get(id);
    }

    public Page<Honor> pagedList(Page<Honor> page) {

        page.setResult(honorDao.pagedList(page).getResult());
        page.setTotalCount(honorDao.getTotalCount());

        return page;
    }

    public void save(Honor achieve) {
        honorDao.save(achieve);
    }

    public void del(Integer id) {
        honorDao.delete(id);
    }

    public List<Honor> recent() {
        return honorDao.getRecent(6);
    }

    public int getTotalCount() {
        return honorDao.getTotalCount();
    }

    public Honor getLeftSiblingById(Integer id) {
        return honorDao.getLeftSiblingByid(id);
    }
    public Honor getRightSiblingById(Integer id) {
        return honorDao.getRightSiblingByid(id);
    }
}
