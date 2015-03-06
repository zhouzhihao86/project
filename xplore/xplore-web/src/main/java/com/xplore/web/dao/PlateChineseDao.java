package com.xplore.web.dao;

import java.io.Serializable;
import java.util.List;

import com.xplore.web.domain.PlateChinese;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;

@Repository
public class PlateChineseDao extends HibernateBaseDao<PlateChinese, Serializable>{

	public Page pagedList(Page<PlateChinese> page){
		
		String hql = "from PlateChinese order by id desc";
		return find(page, hql);
	}

	public List<PlateChinese> getRecent(int maxResults) {

		Criteria criteria = createCriteria();
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	public int getTotalCount() {
		
		String hql = "select count(*) from PlateChinese";
		
		return findLong(hql).intValue();
	}

	public List<PlateChinese> getPlate(Integer plateId, int maxResults) {
		Criteria criteria = createCriteria(Restrictions.eq("plate_id", plateId));
		criteria.setMaxResults(maxResults);
		criteria.addOrder(Order.desc("weight"));
		return criteria.list();
	}
	
	
}
