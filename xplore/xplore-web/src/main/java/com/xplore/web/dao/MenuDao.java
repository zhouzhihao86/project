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
}
