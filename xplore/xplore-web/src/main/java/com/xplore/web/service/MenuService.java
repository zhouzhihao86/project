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

        List<Menu> menuList = new MyList<Menu>();

        for(Menu menu : menuDao.getAll()){
            menuList.add(menu);
        }
        //menuList.addAll(menuDao.getAll());
        //return menuDao.getAll();
        return menuList;
    }

    public Menu getById(Integer id) {
        return menuDao.get(id);
    }

    private class MyList<T> extends ArrayList<Menu> {

        public Menu getMenu(int id){
            for(Menu menu : this){
                if(menu.getId() == id)
                    return menu;
            }
            return null;
        }
    }
}
