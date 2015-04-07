package com.xplore.web.service;

import com.xplore.web.dao.MenuDao;
import com.xplore.web.domain.Menu;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Dotar on 2015/3/12.
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public List<Menu> getAll() {

        return menuDao.getAll();
    }


    public Menu getById(Integer id) {
        return menuDao.get(id);
    }

    public Page<Menu> pagedList(Page<Menu> page) {
        page.setResult(menuDao.pagedList(page).getResult());
        page.setTotalCount(menuDao.getTotalCount());

        return page;
    }

    public void save(Menu menu) {
        menuDao.save(menu);
    }

    public void del(Integer id) {

        menuDao.delete(id);
    }
}
