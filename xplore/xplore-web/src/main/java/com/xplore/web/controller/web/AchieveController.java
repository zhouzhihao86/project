package com.xplore.web.controller.web;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.Achieve;
import com.xplore.web.service.AchieveService;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web/achieve")
public class AchieveController extends BaseController{

    @Autowired
    AchieveService achieveService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            Achieve adminVo = achieveService.getById(id);

            model.addAttribute("domain", adminVo);

            Achieve left = achieveService.getLeftSiblingById(id);
            if(left != null){
                model.addAttribute("prev", left.getId());
                model.addAttribute("prevTitle", left.getTitle());
            }
            Achieve right = achieveService.getRightSiblingById(id);
            if(right != null){
                model.addAttribute("next", right.getId());
                model.addAttribute("nextTitle", right.getTitle());
            }

            return "web/base/third";

        }

        Page<Achieve> page = new Page<Achieve>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_WEB_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<Achieve> achieveList = achieveService.pagedList(page);

        model.addAttribute("domainList", achieveList);

        return "web/base/list";
    }

}