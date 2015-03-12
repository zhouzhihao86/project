package com.xplore.web.service;

import com.xplore.web.dao.SliderDao;
import com.xplore.web.domain.Slider;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 琳 on 2015/3/12.
 */
@Service
@Transactional
public class SliderService {

    @Autowired
    SliderDao sliderDao;


    public Page<Slider> pagedList(Page<Slider> page, boolean b) {

        page.setResult(sliderDao.pagedList(page).getResult());
        page.setTotalCount(sliderDao.getTotalCount());

        return page;
    }

    public void save(Slider slider) {

        sliderDao.save(slider);
    }
}
