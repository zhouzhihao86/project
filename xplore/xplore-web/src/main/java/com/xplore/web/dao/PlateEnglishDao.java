package com.xplore.web.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xplore.web.domain.PlateEnglish;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;

@Repository
public class PlateEnglishDao extends HibernateBaseDao<PlateEnglish, Serializable>{

	public Page pagedList(Page<PlateEnglish> page){
		
		String hql = "from PlateEN order by id desc";
		return find(page, hql);
	}

	public List<PlateEnglish> getRecent(int maxResults) {

		Criteria criteria = createCriteria();
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	public int getTotalCount() {
		
		String hql = "select count(*) from PlateEN";
		
		return findLong(hql).intValue();
	}

	public List<PlateEnglish> getPlate(Integer plateId, int maxResults) {
		Criteria criteria = createCriteria(Restrictions.eq("plateId", plateId));
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("weight"));
		return criteria.list();
	}	
}
