package com.xplore.web.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xplore.web.domain.Plate;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;

@Repository
public class PlateDao extends HibernateBaseDao<Plate, Serializable>{

	public Page pagedList(Page<Plate> page){
		
		String hql = "from Plate order by id desc";
		return find(page, hql);
	}

	public List<Plate> getRecent(int maxResults) {

		Criteria criteria = createCriteria();
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	public int getTotalCount() {
		
		String hql = "select count(*) from Plate";
		
		return findLong(hql).intValue();
	}

	public List<Plate> getPlate(Integer plateId, int maxResults) {
		Criteria criteria = createCriteria(Restrictions.eq("plate_id", plateId));
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("weight"));
		return criteria.list();
	}
	
	
}
