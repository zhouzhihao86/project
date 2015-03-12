package com.xplore.web.service;

import com.xplore.web.dao.MenuDao;
import com.xplore.web.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
