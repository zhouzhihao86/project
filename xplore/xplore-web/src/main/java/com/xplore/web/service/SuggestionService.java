package com.xplore.web.service;

import com.xplore.web.dao.SuggestionDao;
import com.xplore.web.domain.Suggestion;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by damen on 2014/12/20.
 */
@Service
@Transactional
public class SuggestionService {

    @Autowired
    SuggestionDao suggestionDao;

    public Suggestion getById(Integer id) {
        return suggestionDao.get(id);
    }

    public Page<Suggestion> pagedList(Page<Suggestion> page) {

        page.setResult(suggestionDao.pagedList(page).getResult());
        page.setTotalCount(suggestionDao.getTotalCount());

        return page;
    }

    public void save(Suggestion suggestion) {
        suggestionDao.save(suggestion);
    }

    public void del(Integer id) {
        suggestionDao.delete(id);
    }


    public int getTotalCount() {
        return suggestionDao.getTotalCount();
    }

}
