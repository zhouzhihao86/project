package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.Jianshe;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.JiansheService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.ResponseCodesHelper;
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
@Controller("adminJiansheController")
@RequestMapping(value = "admin/jianshe")
public class JiansheController extends BaseController {

    @Autowired
    JiansheService jiansheService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {
        return list(pageNo, null, model);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            Jianshe adminVo = jiansheService.getById(id);

            model.addAttribute("domain", adminVo);

            return "admin/base/third";

        }

        Page<Jianshe> page = new Page<Jianshe>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<Jianshe> jiansheList = jiansheService.pagedList(page);

        model.addAttribute("domainList", jiansheList);


        return "admin/base/list";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/base/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute("form") Jianshe jianshe) {

        jiansheService.save(jianshe);

        return "redirect:list";
    }


    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {

        Jianshe jianshe = jiansheService.getById(id);

        model.addAttribute("domain", jianshe);

        return "admin/base/edit";
    }


    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("form") Jianshe jianshe) {

        jiansheService.save(jianshe);

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

            jiansheService.del(id);

        } catch (AdminException e) {

            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);

        }

        return ajaxResponse;
    }
}
