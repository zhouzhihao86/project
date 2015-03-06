package com.xplore.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.xplore.web.dao.PlateDao;
import com.xplore.web.domain.Plate;
import com.xplore.web.util.Page;

@org.springframework.stereotype.Service
@Transactional
public class PlateService {

	@Autowired
	PlateDao plateDao;
	
	public Plate getById(Integer id){
		return plateDao.get(id);
	}
	
	public Page<Plate>	pagedList(Page<Plate> page){
		
		page.setResult(plateDao.pagedList(page).getResult());
		page.setTotalCount(plateDao.getTotalCount());
		
		return page;
	}

	public List<Plate> getPlate(Integer plateId) {
		
		return plateDao.getPlate(plateId, 5);
	}

}
