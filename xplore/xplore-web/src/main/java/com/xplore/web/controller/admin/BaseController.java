package com.xplore.web.controller.admin;

import com.xplore.web.constants.enums.Country;
import com.xplore.web.domain.Menu;
import com.xplore.web.service.MenuService;
import com.xplore.web.vo.AdminSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dotar on 2015/3/11.
 */
public class BaseController {

    @Autowired
    MenuService menuService;

    @ModelAttribute("adminSession")
    public AdminSession getAdminSession(HttpSession httpSession, Model model){

        AdminSession adminSession = AdminSession.getCurrentAdmin(httpSession);

        model.addAttribute("menu", adminSession.getMenu());
        model.addAttribute("adminInfo", adminSession.getAdmin());
        model.addAttribute("currentResource", adminSession.getCurrentResource());
        model.addAttribute("currentPerm", adminSession.getCurrentPerm());
        List<Menu> menuList = menuService.getAll();
        model.addAttribute("menuList", menuService.getAll());
        model.addAttribute("menuMap", toMap(menuList));
        model.addAttribute("countryList", Country.getAll());

        return adminSession;
    }

    public Map<Integer, Menu> toMap(List<Menu> menuList){
        Map<Integer, Menu> menuMap = new HashMap<Integer, Menu>();
        for(Menu menu : menuList){
            menuMap.put(menu.getId(), menu);
        }

        return menuMap;
    }

    public boolean isChinese(String lan){
        boolean useChineseFlags = true;
        if(lan.equals("en")){
            useChineseFlags = false;
        }
        return useChineseFlags;
    }
}
