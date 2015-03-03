package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.News;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.NewsService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.ResponseCodesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by damen on 2014/12/20.
 * <p/>
 * <p/>
 * 1，修改Autowired为特定
 * 2，list方法中修改autowired的service名字
 * 3，
 */
@Controller("adminNewsController")
@RequestMapping(value = "admin/news")
public class NewsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {
        return list(pageNo, null, model);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            News adminVo = newsService.getById(id);

            model.addAttribute("domain", adminVo);

            return "admin/news/third";

        }

        Page<News> page = new Page<News>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<News> achieveList = newsService.pagedList(page);

        model.addAttribute("domainList", achieveList);


        return "admin/news/list";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/news/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute("form") News achieve) {

        logger.warn("addNews:{}", achieve.getBrief());

        newsService.save(achieve);

        return "redirect:list";
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {

        News achieve = newsService.getById(id);

        model.addAttribute("domain", achieve);

        return "admin/news/edit";
    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("form") News achieve) {

        newsService.save(achieve);

        return "redirect:list";
    }


    @RequestMapping(value = "del", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResponse del(@RequestParam(value = "id", required = false) Integer id, Model model) {

        AjaxResponse ajaxResponse = new AjaxResponse();

        try {

            if (id == null) {
                throw new AdminException(ResponseCodes.KEY_DEL_ADMIN_FAILED);
            }

            newsService.del(id);

        } catch (AdminException e) {

            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);

        }

        return ajaxResponse;
    }
}
