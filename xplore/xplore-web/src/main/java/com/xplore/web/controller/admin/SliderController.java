package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.Constants;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.Slider;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.SliderService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.FileUploadUtil;
import com.xplore.web.utils.ResponseCodesHelper;
import com.xplore.web.utils.UploadUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dotar on 2015/3/12.
 */
@Controller
@RequestMapping("admin/slider")
public class SliderController extends BaseController {

    @Autowired
    SliderService sliderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {

        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {

        Page<Slider> page = new Page<Slider>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize);

        if (pageNo == null) {
            page.setPageNo(1);
        } else {
            page.setPageNo(pageNo);
        }

        Page<Slider> sliderList = sliderService.pagedList(page, true);

        model.addAttribute("domainList", sliderList);

        return "admin/slider/list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/slider/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(HttpServletRequest request) {

        Slider slider = new Slider();

        UploadUtil.handleFormField(request, slider);

        sliderService.save(slider);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {

        Slider slider = sliderService.getById(id);

        model.addAttribute("domain", slider);

        return "admin/slider/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(HttpServletRequest request){
        Slider slider = new Slider();

        UploadUtil.handleFormField(request, slider);

        sliderService.save(slider);

        return "redirect:list";
    }

    @RequestMapping(value = "del", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public AjaxResponse del(@RequestParam(value = "id", required = false) Integer id) {

        AjaxResponse ajaxResponse = new AjaxResponse();

        try {
            if (id == null) {
                throw new AdminException(ResponseCodes.KEY_DEL_ADMIN_FAILED);
            }

            sliderService.del(id);
        } catch (AdminException e) {
            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);
        }

        return ajaxResponse;
    }
}
