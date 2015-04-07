package com.xplore.web.service;

import com.xplore.web.dao.SliderDao;
import com.xplore.web.domain.Slider;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 琳 on 2015/3/12.
 */
@Service
@Transactional
public class SliderService {

    @Autowired
    SliderDao sliderDao;

    public Slider getById(Integer id){

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

    public List<Slider> getByMenuId(Integer id) {

        return sliderDao.getPlate(id, 99);

    }

    public List<Slider> getFirstImgForEachSlider(List<Integer> currentSliderIds) {

        List<Slider> sliders = new ArrayList<Slider>();

        for(Integer id : currentSliderIds){

            List<Slider> tmp = sliderDao.getPlate(id, 1);

            if(tmp == null || tmp.size() == 0) continue;

            sliders.add(tmp.get(0));

        }

        return sliders;


    }
}
