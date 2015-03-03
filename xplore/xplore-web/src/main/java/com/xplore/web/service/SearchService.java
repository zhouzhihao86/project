package com.xplore.web.service;

import com.xplore.web.domain.Search;
import com.xplore.web.util.Page;
import com.xplore.web.dao.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by damen on 2014/12/27.
 */

@Service
@Transactional
public class SearchService {

    @Autowired
    SearchDao searchDao;

    public Page<Search> pagedList(Page<Search> page, String content) {

        page.setResult(searchDao.pagedList(page, content).getResult());
        page.setTotalCount(searchDao.getTotalCount(content));

        return page;
    }
}