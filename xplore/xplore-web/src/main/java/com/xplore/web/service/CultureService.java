package com.xplore.web.service;

import com.xplore.web.dao.CultureDao;
import com.xplore.web.domain.Culture;
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
public class CultureService {

    @Autowired
    CultureDao cultureDao;

    public Culture getById(Integer id) {
        return cultureDao.get(id);
    }

    public Page<Culture> pagedList(Page<Culture> page) {

        page.setResult(cultureDao.pagedList(page).getResult());
        page.setTotalCount(cultureDao.getTotalCount());

        return page;
    }

    public void save(Culture Culture) {
        cultureDao.save(Culture);
    }

    public void del(Integer id) {
        cultureDao.delete(id);
    }

    public List<Culture> recent(){
        return cultureDao.getRecent(6);
    }


    public int getTotalCount() {
        return cultureDao.getTotalCount();
    }

    public Culture getLeftSiblingById(Integer id) {
        return cultureDao.getLeftSiblingByid(id);
    }
    public Culture getRightSiblingById(Integer id) {
        return cultureDao.getRightSiblingByid(id);
    }

}
