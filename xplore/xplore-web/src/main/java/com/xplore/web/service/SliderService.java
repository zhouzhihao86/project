package com.xplore.web.service;

import com.xplore.web.dao.SliderDao;
import com.xplore.web.domain.Slider;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by damen on 2014/12/20.
 */
@Service
@Transactional
public class SliderService {

    @Autowired
    SliderDao sliderDao;

    public Slider getById(Integer id) {
        return sliderDao.get(id);
    }

    public Page<Slider> pagedList(Page<Slider> page) {

        page.setResult(sliderDao.pagedList(page).getResult());
        page.setTotalCount(sliderDao.getTotalCount());

        return page;
    }

    public void save(Slider slider) {
        sliderDao.save(slider);
    }

    public void del(Integer id) {
        sliderDao.delete(id);
    }

    public List<Slider> list() {

        return sliderDao.getAll();

    }

    public List<Slider> recent() {
        return sliderDao.recent(6);
    }


    public int getTotalCount() {
        return sliderDao.getTotalCount();
    }

}
