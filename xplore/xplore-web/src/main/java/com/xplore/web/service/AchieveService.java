package com.xplore.web.service;

import com.xplore.web.dao.AchieveDao;
import com.xplore.web.domain.Achieve;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by damen on 2014/12/20.
 */
@Service
@Transactional
public class AchieveService {

    @Autowired
    AchieveDao achieveDao;

    public Achieve getById(Integer id) {
        return achieveDao.get(id);
    }

    public Page<Achieve> pagedList(Page<Achieve> page) {

        page.setResult(achieveDao.pagedList(page).getResult());
        page.setTotalCount(achieveDao.getTotalCount());

        return page;
    }

    public void save(Achieve achieve) {
        achieveDao.save(achieve);
    }

    public void del(Integer id) {
        achieveDao.delete(id);
    }

    public int getTotalCount() {
        return achieveDao.getTotalCount();
    }

    public Achieve getLeftSiblingById(Integer id) {
        return achieveDao.getLeftSiblingByid(id);
    }
    public Achieve getRightSiblingById(Integer id) {
        return achieveDao.getRightSiblingByid(id);
    }
}
