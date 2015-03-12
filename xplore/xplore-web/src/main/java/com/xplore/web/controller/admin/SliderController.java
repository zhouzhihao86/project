package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.Slider;
import com.xplore.web.service.SliderService;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dotar on 2015/3/12.
 */
@Controller
@RequestMapping("admin/slider")
public class SliderController extends BaseController{

    @Autowired
    SliderService sliderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value="p", required = false)Integer pageNo, Model model){

        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false)Integer pageNo, Model model){

        Page<Slider> page = new Page<Slider>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize);

        if (pageNo == null) {
            page.setPageNo(1);
        } else {
            page.setPageNo(pageNo);
        }

        Page<Slider> sliderList = sliderService.pagedList(page, true);

        model.addAttribute("sliderList", sliderList);

        return "admin/slider/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/slider/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(HttpServletRequest request, @ModelAttribute("form") Slider slider) {

        sliderService.save(slider);

        return "redirect:list";
    }
}
