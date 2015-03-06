package com.xplore.web.controller.web;

import com.xplore.web.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by damen on 2014/12/26.
 */
public class BaseController {

    @Autowired
    PlateService plateService;

    @ModelAttribute("sidebar")
    public void getSideBarData(Model model) {

        model.addAttribute("plateRecent1", plateService.getPlate(1));
        model.addAttribute("plateRecent2", plateService.getPlate(2));
        model.addAttribute("plateRecent3", plateService.getPlate(3));
        model.addAttribute("plateRecent4", plateService.getPlate(4));

    }

    public String getVm(String vmName, String lan) {
        StringBuilder sb = new StringBuilder();
        return sb.append("web/").append(lan).append("/").append(vmName).toString();
    }
}
