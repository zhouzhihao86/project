package com.xplore.web.service;

import java.util.ArrayList;
import java.util.List;

import com.xplore.web.dao.MenuDao;
import com.xplore.web.dao.PlateEnglishDao;
import com.xplore.web.domain.Menu;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.PlateEnglish;
import com.xplore.web.vo.PlateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xplore.web.dao.PlateChineseDao;
import com.xplore.web.util.Page;

@Service
@Transactional
public class PlateService {

	@Autowired
	PlateChineseDao plateChineseDao;

	@Autowired
	PlateEnglishDao plateEnglishDao;

	@Autowired
	MenuDao menuDao;
	
	public Object getById(Integer id, boolean useChineseFlags){
		if(useChineseFlags)
			return plateChineseDao.get(id);
		else
			return plateEnglishDao.get(id);
	}
	
	public Page<PlateVo> pagedList(MenuService menuService, Page page, boolean useChineseFlags){
        List<PlateVo> plateVoList = new ArrayList<PlateVo>();
		if(useChineseFlags) {
			//page.setResult(plateChineseDao.pagedList(page).getResult());
            List<PlateChinese> plateChineseList = plateChineseDao.pagedList(page).getResult();
            for(PlateChinese plateChinese : plateChineseList){
                PlateVo plateVo = new PlateVo(menuService, plateChinese, true);
                plateVoList.add(plateVo);
            }
			page.setTotalCount(plateChineseDao.getTotalCount());
		} else {
			//page.setResult(plateEnglishDao.pagedList(page).getResult());
            List<PlateEnglish> plateEnglishList = plateEnglishDao.pagedList(page).getResult();
            for(PlateEnglish plateEnglish : plateEnglishList){
                PlateVo plateVo = new PlateVo(menuService, plateEnglish, false);
                plateVoList.add(plateVo);
            }
			page.setTotalCount(plateEnglishDao.getTotalCount());
		}
        page.setResult(plateVoList);
		return page;
	}

	public List getPlate(Integer plateId, boolean useChineseFlags) {
		int maxResults = 5;

		if(useChineseFlags)
			return plateChineseDao.getPlate(plateId, 99);
		else
			return plateEnglishDao.getPlate(plateId, 99);
	}

	public void save(PlateChinese plateChinese) {

		plateChineseDao.save(plateChinese);
	}

	public void save(PlateEnglish plateEnglish){

		plateEnglishDao.save(plateEnglish);
	}

	public void del(Integer id, boolean useChineseFlags) {

		if(useChineseFlags)
			plateChineseDao.delete(id);
		else
			plateEnglishDao.delete(id);
	}

    public Menu getMenuByPlateId(Integer plateId) {

		return menuDao.get(plateId);
    }

	public List<Menu> getAllMenu() {

		return menuDao.getAll();

	}
}
