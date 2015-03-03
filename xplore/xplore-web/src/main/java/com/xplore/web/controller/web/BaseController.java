package com.xplore.web.controller.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by damen on 2014/12/26.
 */
public class BaseController {


    @ModelAttribute("sidebar")
    public void getSideBarData(Model model) {

    }
}
