package com.xplore.web.controller.web;

import com.xplore.web.domain.Videos;
import com.xplore.web.service.VideosService;
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
@RequestMapping(value = "web/videos")
public class VideosController extends BaseController{

    @Autowired
    VideosService videosService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        Page<Videos> page = new Page<Videos>();

        Integer pageSize = 12;

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<Videos> achieveList = videosService.pagedList(page);

        model.addAttribute("domainList", achieveList);

        return "web/videos/list";
    }

}