package com.xplore.web.service;

import com.xplore.web.dao.VideosDao;
import com.xplore.web.domain.Videos;
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
public class VideosService {

    @Autowired
    VideosDao videosDao;

    public Videos getById(Integer id) {
        return videosDao.get(id);
    }

    public Page<Videos> pagedList(Page<Videos> page) {

        page.setResult(videosDao.pagedList(page).getResult());
        page.setTotalCount(videosDao.getTotalCount());

        return page;
    }

    public void save(Videos videos) {
        videosDao.save(videos);
    }

    public void del(Integer id) {
        videosDao.delete(id);
    }

    public List<Videos> recent(){
        return videosDao.getRecent(1);
    }


    public int getTotalCount() {
        return videosDao.getTotalCount();
    }
}
