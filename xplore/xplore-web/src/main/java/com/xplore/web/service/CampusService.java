package com.xplore.web.service;

import com.xplore.web.dao.CampusChineseDao;
import com.xplore.web.dao.CampusEnglishDao;
import com.xplore.web.domain.CampusEnglish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
