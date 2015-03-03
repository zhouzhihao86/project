package com.xplore.web.dao;

import com.xplore.web.domain.News;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by damen on 2014/12/20.
 */
@Repository
public class NewsDao extends HibernateBaseDao<News, Integer> {
    public Page pagedList(Page<News> page) {

        String hql = "from News order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from News";

        return findLong(hql).intValue();

    }

    public List<News> recent(int maxResults) {
        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();

    }


    public News getLeftSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.lt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.desc("id"));
        return (News) criteria.uniqueResult();

    }

    public News getRightSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.gt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.asc("id"));
        return (News) criteria.uniqueResult();

    }
}
