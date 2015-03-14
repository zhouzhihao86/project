package com.xplore.web.service;

import com.xplore.web.dao.CampusChineseDao;
import com.xplore.web.dao.CampusEnglishDao;
import com.xplore.web.domain.CampusChinese;
import com.xplore.web.domain.CampusEnglish;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dotar on 2015/3/12.
 */
@Service
@Transactional
public class CampusService {

    @Autowired
    CampusChineseDao campusChineseDao;

    @Autowired
    CampusEnglishDao campusEnglishDao;

    public Object getById(Integer id, boolean useChineseFlags) {

        if(useChineseFlags)
            return campusChineseDao.get(id);
        else
            return campusEnglishDao.get(id);
    }

    public List getList(int countryId, boolean useChineseFlags) {

        if(useChineseFlags)
            return campusChineseDao.getAllListByCountry(countryId, 10);
        else
            return campusEnglishDao.getAllListByCountry(countryId, 10);
    }

    public Page pagedList(Page page, boolean useChineseFlags) {

        if(useChineseFlags) {
            page.setResult(campusChineseDao.pagedList(page).getResult());
            page.setTotalCount(campusChineseDao.getTotalCount());
        } else {
            page.setResult(campusEnglishDao.pagedList(page).getResult());
            page.setTotalCount(campusEnglishDao.getTotalCount());
        }
        return page;
    }

    public void save(CampusEnglish campusEnglish) {
        campusEnglishDao.save(campusEnglish);
    }

    public void save(CampusChinese campusChinese) {
        campusChineseDao.save(campusChinese);
    }

    public void del(Integer id, boolean useChineseFlags) {
        if(useChineseFlags){
            campusChineseDao.delete(id);
        } else {
            campusEnglishDao.delete(id);
        }

    }
}
