package com.xplore.web.dao;

import com.xplore.web.domain.Videos;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by damen on 2014/12/20.
 */
@Repository
public class VideosDao extends HibernateBaseDao<Videos, Integer> {
    public Page pagedList(Page<Videos> page) {

        String hql = "from Videos order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Videos";

        return findLong(hql).intValue();

    }

    public List<Videos> getRecent(int maxResults){
        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}
