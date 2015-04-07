package com.xplore.web.dao;

import com.xplore.web.domain.Country;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 琳 on 2015/3/28.
 */
@Repository
public class CountryDao extends HibernateBaseDao<Country, Serializable> {

    public Page pagedList(Page<Country> page){

        String hql = "from Country order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Country";

        return findLong(hql).intValue();
    }

}
