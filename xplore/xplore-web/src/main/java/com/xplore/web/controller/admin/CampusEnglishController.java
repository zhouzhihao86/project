package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.CampusChinese;
import com.xplore.web.domain.CampusEnglish;
import com.xplore.web.domain.PlateEnglish;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.CampusService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.ResponseCodesHelper;
import com.xplore.web.vo.AdminSession;
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
@RequestMapping(value = "admin/campusEnglish")
public class CampusEnglishController extends BaseController{

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

        Page campusList = campusService.pagedList(page, false);

        model.addAttribute("domainList", campusList);

        return "admin/campus/list";
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public String doList(@ModelAttribute("form") CampusEnglish campusEnglish, @ModelAttribute("adminSession") AdminSession adminSession){

        campusService.save(campusEnglish);

        return "redirect:/admin/" + adminSession.getCurrentResource().getUri();
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/campus/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute("form") CampusEnglish campusEnglish) {

        campusService.save(campusEnglish);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "type", required = false) String type, Model model) {

        CampusEnglish campusEnglish = (CampusEnglish) campusService.getById(id, false);
        model.addAttribute("domain", campusEnglish);

        if(type.equals("profile")){
            model.addAttribute("pageTitle", "profile");
            model.addAttribute("pageContent", campusEnglish.getProfile());

        } else if(type.equals("facts")) {
            model.addAttribute("pageTitle", "facts");
            model.addAttribute("pageContent", campusEnglish.getFacts());

        } else if(type.equals("curriculum")) {
            model.addAttribute("pageTitle", "curriculum");
            model.addAttribute("pageContent", campusEnglish.getCurriculum());

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

        CampusEnglish campusEnglish = (CampusEnglish) campusService.getById(id, false);
        if(contentType.equals("profile")){
            campusEnglish.setProfile(content);

        } else if(contentType.equals("facts")) {
            campusEnglish.setFacts(content);

        } else if(contentType.equals("curriculum")) {
            campusEnglish.setCurriculum(content);

        } else {
            return "redirect:list";
        }

        campusService.save(campusEnglish);

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

            campusService.del(id, false);
        } catch (AdminException e) {
            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);
        }

        return ajaxResponse;
    }
}
