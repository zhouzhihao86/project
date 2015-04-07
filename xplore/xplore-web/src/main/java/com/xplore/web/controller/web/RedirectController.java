package com.xplore.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by damen on 2015/3/29.
 */
@Controller
@RequestMapping(value = "web")
public class RedirectController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, Model model) {
        return "redirect:http://www.xploretheworld.cn/cn";
    }
}
