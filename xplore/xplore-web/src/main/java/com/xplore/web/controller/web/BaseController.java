package com.xplore.web.controller.web;

import com.xplore.web.domain.CampusChinese;
import com.xplore.web.service.CampusService;
import com.xplore.web.service.PlateService;
import com.xplore.web.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
        model.addAttribute("plateRecent5", plateService.getPlate(5, useChineseFlags));
        model.addAttribute("plateRecent6", plateService.getPlate(6, useChineseFlags));
        model.addAttribute("plateRecent7", plateService.getPlate(7, useChineseFlags));

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

    /**
     * 统一异常处理
     */
    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {

        request.setAttribute("ex", ex);

        ex.printStackTrace();

        String uri = request.getRequestURI();

        if(uri != null && uri.indexOf("cn") != -1){
            return "web/cn/404";
        }else{
            return "web/en/404";
        }
    }

}
