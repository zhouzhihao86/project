package com.xplore.web.service;

import com.xplore.web.dao.MenuDao;
import com.xplore.web.domain.Menu;
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

    public Map<Integer, Menu> getMap(){
        Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
        for(Menu menu : menuDao.getAll()){
            menuMap.put(menu.getId(), menu);
        }

        return menuMap;
    }

    public Menu getById(Integer id) {
        return menuDao.get(id);
    }

}
