package com.xplore.web.dao;

import com.xplore.web.domain.Slider;
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
public class SliderDao extends HibernateBaseDao<Slider, Integer> {
    public Page pagedList(Page<Slider> page) {

        String hql = "from Slider order by id desc";
        return find(page, hql);

    }

    public int getTotalCount() {

        String hql = "select count(*) from Slider";

        return findLong(hql).intValue();

    }

    public List<Slider> recent(int maxResults) {
        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}
