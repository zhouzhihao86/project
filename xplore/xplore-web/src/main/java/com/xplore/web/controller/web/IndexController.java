package com.xplore.web.controller.web;

import com.xplore.web.domain.Menu;
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

        Menu menu = null;

        if (useChineseFlags) {

            PlateChinese plateChinese = (PlateChinese) plate;

            model.addAttribute("current", model.asMap().get("plateRecent" + plateChinese.getPlateId()));

            menu = plateService.getMenuByPlateId(plateChinese.getPlateId());

        } else {

            PlateEnglish plateEnglish = (PlateEnglish) plate;

            model.addAttribute("current", model.asMap().get("plateRecent" + plateEnglish.getPlateId()));

            menu = plateService.getMenuByPlateId(plateEnglish.getPlateId());

        }

        model.addAttribute("article", plate);

        model.addAttribute("menu", menu);

        return getVm("groups", lan);
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "web/contact";
    }

    @RequestMapping(value = "bookingOnline", method = RequestMethod.GET)
    public String bookingOnline(@PathVariable String lan, Model model) {
        return getVm("bookingOnline", lan);
    }

    @RequestMapping(value = "campus/england", method = RequestMethod.GET)
    public String britain(@PathVariable String lan, Model model) {
        return getVm("britain", lan);
    }

    @RequestMapping(value = "campus/america", method = RequestMethod.GET)
    public String america(@PathVariable String lan,Model model) {
        return getVm("america", lan);
    }

    @RequestMapping(value = "campus/china", method = RequestMethod.GET)
    public String china(@PathVariable String lan, Model model) {
        return getVm("china", lan);
    }

    @RequestMapping(value = "campus/{country}/{id}", method = RequestMethod.GET)
    public String campusDetail(@PathVariable String lan, @PathVariable String country, @PathVariable Integer id, Model model) {

        boolean useChineseFlags = isChinese(lan);

        Object detail = campusService.getById(id, useChineseFlags);

        model.addAttribute("country", country);

        model.addAttribute("detail", detail);

        return getVm("campusDetail", lan);
    }
}