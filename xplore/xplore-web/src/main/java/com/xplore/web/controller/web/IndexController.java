package com.xplore.web.controller.web;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.IpCnt;
import com.xplore.web.domain.Search;
import com.xplore.web.service.*;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by damen on 2014/12/14.
 */
@Controller
@RequestMapping(value = "web")
public class IndexController extends BaseController {

    @Autowired
    ServiceService serviceService;

    @Autowired
    HonorService honorService;

    @Autowired
    NewsService newsService;

    @Autowired
    PicNewsService picNewsService;

    @Autowired
    SliderService sliderService;

    @Autowired
    SearchService searchService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, Model model) {

        String sessionId = request.getSession().getId();

        if(!StringUtils.isEmpty(sessionId)){

            try {
                IpCnt.add(sessionId);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


        model.addAttribute("serviceRecent", serviceService.recent());

        model.addAttribute("honorRecent", honorService.recent());

        model.addAttribute("newsRecent", newsService.recent());

        model.addAttribute("sliderRecent", sliderService.recent());

        model.addAttribute("ipCnt", IpCnt.getIpCnt());

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

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "s", required = false) String searchStr ,Model model) {

        if(StringUtils.isEmpty(searchStr)){
            return "web/index";
        }

        Page<Search> page = new Page<Search>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_WEB_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        searchService.pagedList(page, searchStr);

        model.addAttribute("domainList", page);

        model.addAttribute("searchStr", searchStr);

        return "web/search/list";
    }

}