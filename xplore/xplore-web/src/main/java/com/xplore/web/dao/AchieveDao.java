package com.xplore.web.dao;

import com.xplore.web.domain.Achieve;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by damen on 2014/12/20.
 */
@Repository
public class AchieveDao extends HibernateBaseDao<Achieve, Integer> {
    public Page pagedList(Page<Achieve> page) {

        String hql = "from Achieve order by id desc3";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Achieve";

        return findLong(hql).intValue();

    }

    public Achieve getLeftSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.lt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.desc("id"));
        return (Achieve) criteria.uniqueResult();

    }

    public Achieve getRightSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.gt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.asc("id"));
        return (Achieve) criteria.uniqueResult();

    }
}
