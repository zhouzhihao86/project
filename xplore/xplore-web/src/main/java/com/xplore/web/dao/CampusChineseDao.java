package com.xplore.web.dao;

import com.xplore.web.domain.CampusChinese;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dotar on 2015/3/12.
 */
@Repository
public class CampusChineseDao extends HibernateBaseDao<CampusChinese, Serializable>{

    public Page pagedList(Page<CampusChinese> page){

        String hql = "from CampusChinese order by id desc";
        return find(page, hql);
    }

    public List<CampusChinese> getRecent(int maxResults) {

        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    public int getTotalCount() {

        String hql = "select count(*) from CampusChinese";

        return findLong(hql).intValue();
    }

    public List<CampusChinese> getPlate(Integer plateId, int maxResults) {

        Criteria criteria = createCriteria(Restrictions.eq("plateId", plateId));
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("weight"));
        return criteria.list();
    }
}
