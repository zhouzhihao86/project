package com.xplore.web.dao;

import com.xplore.web.domain.Culture;
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
public class CultureDao extends HibernateBaseDao<Culture, Integer> {
    public Page pagedList(Page<Culture> page) {

        String hql = "from Culture order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Culture";

        return findLong(hql).intValue();

    }

    public List<Culture> getRecent(int maxResults){
        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }


    public Culture getLeftSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.lt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.desc("id"));
        return (Culture) criteria.uniqueResult();

    }

    public Culture getRightSiblingByid(Integer id) {

        Criteria criteria = createCriteria(Restrictions.gt("id", id));
        criteria.setMaxResults(1);
        criteria.addOrder(Order.asc("id"));
        return (Culture) criteria.uniqueResult();

    }

}
