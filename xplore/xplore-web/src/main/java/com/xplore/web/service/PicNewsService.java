package com.xplore.web.service;

import com.xplore.web.dao.PicNewsDao;
import com.xplore.web.domain.PicNews;
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
public class PicNewsService {

    @Autowired
    PicNewsDao picNewsDao;

    public PicNews getById(Integer id) {
        return picNewsDao.get(id);
    }

    public Page<PicNews> pagedList(Page<PicNews> page) {

        page.setResult(picNewsDao.pagedList(page).getResult());
        page.setTotalCount(picNewsDao.getTotalCount());

        return page;
    }

    public void save(PicNews achieve) {
        picNewsDao.save(achieve);
    }

    public void del(Integer id) {
        picNewsDao.delete(id);
    }

    public List<PicNews> recent() {
        return picNewsDao.recent(6);
    }


    public int getTotalCount() {
        return picNewsDao.getTotalCount();
    }

    public PicNews getLeftSiblingById(Integer id) {
        return picNewsDao.getLeftSiblingByid(id);
    }
    public PicNews getRightSiblingById(Integer id) {
        return picNewsDao.getRightSiblingByid(id);
    }
}
