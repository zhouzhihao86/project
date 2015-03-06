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

	@Autowired
	PlateService plateService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(@PathVariable String lan, HttpServletRequest request, Model model) {

    	model.addAttribute("plate1Recent", plateService.getPlate(1));
    	model.addAttribute("plate2Recent", plateService.getPlate(2));
    	model.addAttribute("plate3Recent", plateService.getPlate(3));
    	model.addAttribute("plate4Recent", plateService.getPlate(4));
    	
        return "web/"+ lan +"/index";
    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public String intro(Model model) {
        return "web/groups";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }


}