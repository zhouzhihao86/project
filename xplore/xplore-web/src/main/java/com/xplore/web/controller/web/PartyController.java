package com.xplore.web.controller.web;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.Party;
import com.xplore.web.service.PartyService;
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
@RequestMapping(value = "web/party")
public class PartyController extends BaseController{

    @Autowired
    PartyService partyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            Party adminVo = partyService.getById(id);

            model.addAttribute("domain", adminVo);

            Party left = partyService.getLeftSiblingById(id);
            if(left != null){
                model.addAttribute("prev", left.getId());
                model.addAttribute("prevTitle", left.getTitle());
            }
            Party right = partyService.getRightSiblingById(id);
            if(right != null){
                model.addAttribute("next", right.getId());
                model.addAttribute("nextTitle", right.getTitle());
            }

            return "web/base/third";

        }

        Page<Party> page = new Page<Party>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_WEB_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<Party> partyList = partyService.pagedList(page);

        model.addAttribute("domainList", partyList);

        return "web/base/list";
    }

}