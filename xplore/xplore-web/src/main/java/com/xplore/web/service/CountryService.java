package com.xplore.web.service;

import com.xplore.web.domain.Country;
import com.xplore.web.dao.CountryDao;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 琳 on 2015/3/28.
 */
@Service
@Transactional
public class CountryService {

    @Autowired
    CountryDao countryDao;

    public Country getById(Integer id){

        return countryDao.get(id);
    }

    public Page<Country> pagedList(Page<Country> page) {

        page.setResult(countryDao.pagedList(page).getResult());
        page.setTotalCount(countryDao.getTotalCount());

        return page;
    }

    public void save(Country country) {

        countryDao.save(country);
    }
}
