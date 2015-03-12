package com.xplore.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

/**
 * Created by Dotar on 2015/3/12.
 */
@Controller
@RequestMapping("admin/slider")
public class SliderController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value="p", required = false)Integer pageNo, Model model){

        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false)Integer pageNo, Model model){



        return "admin/slider/list";
    }
}
