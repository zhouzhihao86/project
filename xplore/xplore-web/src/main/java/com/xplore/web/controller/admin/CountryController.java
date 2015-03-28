package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.Country;
import com.xplore.web.service.CountryService;
import com.xplore.web.util.Page;
import com.xplore.web.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 琳 on 2015/3/28.
 */
@Controller
@RequestMapping(value = "admin/country")
public class CountryController extends BaseController{

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false)Integer pageNo, Model model){
        return list(pageNo, model);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false)Integer pageNo, Model model){
        Page<Country> page = new Page<Country>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize);

        if(pageNo == null){
            page.setPageNo(1);
        } else {
            page.setPageNo(pageNo);
        }

        Page<Country> countryList = countryService.pagedList(page);

        model.addAttribute("domainList", countryList);

        return "admin/country/list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = false)Integer id, Model model){

        Country country = countryService.getById(id);

        model.addAttribute("domain", country);

        return "admin/country/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String doEdit(HttpServletRequest request){

        Country country = new Country();

        UploadUtil.handleFormField(request, country);

        countryService.save(country);

        return "redirect:list";
    }
}
