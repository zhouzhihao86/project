package com.xplore.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web")
public class IndexController extends BaseController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, Model model) {


        return "web/index";
    }

    @RequestMapping(value = "intro", method = RequestMethod.GET)
    public String intro(Model model) {
        return "web/intro";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }


}