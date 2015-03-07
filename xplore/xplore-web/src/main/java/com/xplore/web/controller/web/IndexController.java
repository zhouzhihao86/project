package com.xplore.web.controller.web;

import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.PlateEnglish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
    public String intro(@PathVariable Integer articleId, @PathVariable String lan, Model model) {

        boolean useChineseFlags = isChinese(lan);

        Object plate = plateService.getById(articleId, useChineseFlags);

        if (useChineseFlags) {

            PlateChinese plateChinese = (PlateChinese) plate;

            model.addAttribute("current", model.asMap().get(plateChinese.getParentUrl()));

        } else {

            PlateEnglish plateEnglish = (PlateEnglish) plate;

            model.addAttribute("current", model.asMap().get(plateEnglish.getParentUrl()));

        }

        model.addAttribute("article", plate);


        return getVm("groups", lan);
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }


}