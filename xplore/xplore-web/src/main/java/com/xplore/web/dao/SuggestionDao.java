package com.xplore.web.dao;

import com.xplore.web.domain.Suggestion;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.springframework.stereotype.Repository;

/**
 * Created by damen on 2014/12/20.
 */
@Repository
public class SuggestionDao extends HibernateBaseDao<Suggestion, Integer> {
    public Page pagedList(Page<Suggestion> page) {

        String hql = "from Suggestion order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Suggestion";

        return findLong(hql).intValue();

    }
}
