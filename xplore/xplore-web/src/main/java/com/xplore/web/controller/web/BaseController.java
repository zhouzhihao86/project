package com.xplore.web.controller.web;

import com.xplore.web.service.CultureService;
import com.xplore.web.service.JiansheService;
import com.xplore.web.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by damen on 2014/12/26.
 */
public class BaseController {

    @Autowired
    CultureService cultureService;

    @Autowired
    VideosService videosService;

    @Autowired
    JiansheService jiansheService;


    @ModelAttribute("sidebar")
    public void getSideBarData(Model model) {

        model.addAttribute("cultureRecent", cultureService.recent());
        model.addAttribute("videosRecent", videosService.recent());
        model.addAttribute("jiansheRecent", jiansheService.recent());

    }
}
