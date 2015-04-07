package com.xplore.web.dao;

import com.xplore.web.domain.Menu;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class MenuDao extends HibernateBaseDao<Menu, Serializable>{

	public List<Menu> getAll(){
        return super.getAll();
    }

    public Page pagedList(Page<Menu> page){

        String hql = "from Menu order by id desc";
        return find(page, hql);
    }

    public List<Menu> getRecent(int maxResults) {

        Criteria criteria = createCriteria();
        criteria.setMaxResults(maxResults);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

    public int getTotalCount() {

        String hql = "select count(*) from Menu";

        return findLong(hql).intValue();
    }
}
