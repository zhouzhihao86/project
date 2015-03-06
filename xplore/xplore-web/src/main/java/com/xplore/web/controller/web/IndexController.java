package com.xplore.web.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xplore.web.service.PlateService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web/{lan}")
public class IndexController extends BaseController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(@PathVariable String lan, HttpServletRequest request, Model model) {

        return getVm("index", lan);
    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public String intro(@PathVariable String lan, Model model) {
        return getVm("index", lan);
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }



}