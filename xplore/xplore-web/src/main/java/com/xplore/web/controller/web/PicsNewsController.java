package com.xplore.web.controller.web;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.PicNews;
import com.xplore.web.domain.Slider;
import com.xplore.web.service.PicNewsService;
import com.xplore.web.service.SliderService;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web/picNews")
public class PicsNewsController extends BaseController{

    @Autowired
    PicNewsService picNewsService;

    @Autowired
    SliderService sliderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            PicNews adminVo = picNewsService.getById(id);

            model.addAttribute("domain", adminVo);

            PicNews left = picNewsService.getLeftSiblingById(id);
            if(left != null){
                model.addAttribute("prev", left.getId());
                model.addAttribute("prevTitle", left.getTitle());
            }
            PicNews right = picNewsService.getRightSiblingById(id);
            if(right != null){
                model.addAttribute("next", right.getId());
                model.addAttribute("nextTitle", right.getTitle());
            }

            return "web/base/third";

        }

        Page<PicNews> page = new Page<PicNews>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_WEB_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<PicNews> picNewsList = picNewsService.pagedList(page);

        model.addAttribute("domainList", picNewsList);

        List<Slider> sliderList = sliderService.recent();

        model.addAttribute("sliderRecent", sliderList);


        return "web/picnews/list";
    }
}