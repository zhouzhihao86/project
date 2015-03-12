package com.xplore.web.controller.web;

import com.xplore.web.domain.CampusChinese;
import com.xplore.web.service.CampusService;
import com.xplore.web.service.PlateService;
import com.xplore.web.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by damen on 2014/12/26.
 */
public class BaseController {

    @Autowired
    PlateService plateService;

    @Autowired
    CampusService campusService;

    @ModelAttribute("sidebar")
    public void getSideBarData(@PathVariable String lan, Model model) {


        boolean useChineseFlags = isChinese(lan);

        model.addAttribute("plateRecent1", plateService.getPlate(1, useChineseFlags));
        model.addAttribute("plateRecent2", plateService.getPlate(2, useChineseFlags));
        model.addAttribute("plateRecent3", plateService.getPlate(3, useChineseFlags));
        model.addAttribute("plateRecent4", plateService.getPlate(4, useChineseFlags));

        model.addAttribute("lan", lan);

    }

    public String getVm(String vmName, String lan) {
        StringBuilder sb = new StringBuilder();
        return sb.append("web/").append(lan).append("/").append(vmName).toString();
    }

    public boolean isChinese(String lan){
        boolean useChineseFlags = true;
        if(lan.equals("en")){
            useChineseFlags = false;
        }
        return useChineseFlags;
    }
}
