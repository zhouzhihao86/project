package com.xplore.web.service;

import com.xplore.web.dao.NewsDao;
import com.xplore.web.domain.News;
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
public class NewsService {

    @Autowired
    NewsDao newsDao;

    public News getById(Integer id) {
        return newsDao.get(id);
    }

    public Page<News> pagedList(Page<News> page) {

        page.setResult(newsDao.pagedList(page).getResult());
        page.setTotalCount(newsDao.getTotalCount());

        return page;
    }

    public void save(News achieve) {
        newsDao.save(achieve);
    }

    public void del(Integer id) {
        newsDao.delete(id);
    }

    public List<News> recent() {
        return newsDao.recent(6);
    }


    public int getTotalCount() {
        return newsDao.getTotalCount();
    }

    public News getLeftSiblingById(Integer id) {
        return newsDao.getLeftSiblingByid(id);
    }
    public News getRightSiblingById(Integer id) {
        return newsDao.getRightSiblingByid(id);
    }
}
