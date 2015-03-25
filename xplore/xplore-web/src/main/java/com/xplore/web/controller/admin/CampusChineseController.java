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

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public String doList(@ModelAttribute("form") CampusChinese campusChinese){

        campusService.save(campusChinese);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "type", required = false) String type, Model model) {

        CampusChinese campusChinese = (CampusChinese) campusService.getById(id, true);
        model.addAttribute("domain", campusChinese);

        if(type.equals("profile")){
            model.addAttribute("pageTitle", "profile");
            model.addAttribute("pageContent", campusChinese.getProfile());

        } else if(type.equals("facts")) {
            model.addAttribute("pageTitle", "facts");
            model.addAttribute("pageContent", campusChinese.getFacts());

        } else if(type.equals("curriculum")) {
            model.addAttribute("pageTitle", "curriculum");
            model.addAttribute("pageContent", campusChinese.getCurriculum());

        } else {
            return "admin/campus/list";
        }

        return "admin/campus/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(HttpServletRequest request) {

        Map<String, String[]> params = request.getParameterMap();
        Integer id = Integer.valueOf(params.get("id")[0]);
        String contentType = params.get("contentType")[0];
        String content = params.get("content")[0];

        CampusChinese campusChinese = (CampusChinese) campusService.getById(id, true);
        if(contentType.equals("profile")){
            campusChinese.setProfile(content);

        } else if(contentType.equals("facts")) {
            campusChinese.setFacts(content);

        } else if(contentType.equals("curriculum")) {
            campusChinese.setCurriculum(content);

        } else {
            return "redirect:list";
        }

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
