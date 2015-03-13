package com.xplore.web.dao;

import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.Slider;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 琳 on 2015/3/12.
 */
@Repository
public class SliderDao extends HibernateBaseDao<Slider, Serializable>{

    public Page pagedList(Page<Slider> page){

        String hql = "from Slider order by id desc";
        return find(page, hql);
    }

    public List<Slider> getRecent(int maxResults) {

        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    public int getTotalCount() {

        String hql = "select count(*) from Slider";

        return findLong(hql).intValue();
    }

    public List<Slider> getPlate(Integer plateId, int maxResults) {

        Criteria criteria = createCriteria(Restrictions.eq("plateId", plateId));
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("weight"));
        return criteria.list();
    }
}
