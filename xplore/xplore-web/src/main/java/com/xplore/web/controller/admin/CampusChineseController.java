package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.CampusChinese;
import com.xplore.web.domain.CampusEnglish;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.CampusService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.ResponseCodesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 琳 on 2015/3/14.
 */
@Controller
@RequestMapping(value = "admin/campusChinese")
public class CampusChineseController extends BaseController {

    @Autowired
    CampusService campusService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {

        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false)Integer pageNo, Model model){

        Page page = new Page();
        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);
        page.setPageSize(pageSize);

        if (pageNo == null) {
            page.setPageNo(1);
        } else {
            page.setPageNo(pageNo);
        }

        Page campusList = campusService.pagedList(page, true);

        model.addAttribute("domainList", campusList);

        return "admin/campus/list";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/campus/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute("form") CampusChinese campusChinese) {

        campusService.save(campusChinese);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {

        CampusChinese campusChinese = (CampusChinese) campusService.getById(id, true);
        model.addAttribute("domain", campusChinese);

        return "admin/campus/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("form") CampusChinese campusChinese) {
        campusService.save(campusChinese);

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

            campusService.del(id, true);
        } catch (AdminException e) {
            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);
        }

        return ajaxResponse;
    }
}
