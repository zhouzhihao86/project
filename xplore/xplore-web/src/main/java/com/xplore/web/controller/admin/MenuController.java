package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.Menu;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.MenuService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.ResponseCodesHelper;
import com.xplore.web.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 琳 on 2015/3/28.
 */
@Controller
@RequestMapping(value = "admin/menu")
public class MenuController extends BaseController{

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model){

        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, Model model){

        Page<Menu> page = new Page<Menu>();
        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize);

        if(pageNo == null){
            page.setPageNo(1);
        } else {
            page.setPageNo(pageNo);
        }

        Page<Menu> pageList = menuService.pagedList(page);

        model.addAttribute("domainList", pageList);

        return "admin/menu/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(@RequestParam(value = "id", required = false) Integer id, Model model){

        return "admin/menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(HttpServletRequest request){

        Menu menu = new Menu();

        UploadUtil.handleFormField(request, menu);

        menuService.save(menu);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model){

        Menu menu = menuService.getById(id);

        model.addAttribute("domain", menu);

        return "admin/menu/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(HttpServletRequest request){

        Menu menu = new Menu();

        UploadUtil.handleFormField(request, menu);

        menuService.save(menu);

        return "redirect:list";
    }

    @RequestMapping(value="del", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResponse del(@RequestParam(value = "id", required = false)Integer id){

        AjaxResponse ajaxResponse = new AjaxResponse();

        try{
            if(id == null)
                throw new AdminException(ResponseCodes.KEY_DEL_ADMIN_FAILED);

            menuService.del(id);
        } catch (AdminException e) {
            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);
        }

        return ajaxResponse;
    }
}
