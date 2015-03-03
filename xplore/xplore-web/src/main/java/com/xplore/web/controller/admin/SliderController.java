package com.xplore.web.controller.admin;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.Constants;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.Slider;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.SliderService;
import com.xplore.web.util.Page;
import com.xplore.web.util.StringUtils;
import com.xplore.web.utils.ResponseCodesHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by damen on 2014/12/24.
 */
@Controller("adminSliderController")
@RequestMapping(value = "admin/slider")
public class SliderController extends BaseController{

    @Autowired
    SliderService sliderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String defaultList(@RequestParam(value = "p", required = false) Integer pageNo, Model model) {
        return list(pageNo, null, model);
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "p", required = false) Integer pageNo, @RequestParam(value = "id", required = false) Integer id, Model model) {

        if (id != null) {

            Slider adminVo = sliderService.getById(id);

            model.addAttribute("domain", adminVo);

            return "admin/slider/third";

        }

        Page<Slider> page = new Page<Slider>();

        Integer pageSize = AdminConfig.getInt(AdminConfig.KEY_PAGE_SIZE);

        page.setPageSize(pageSize); //初始化每页条数

        if (pageNo == null) {
            page.setPageNo(1);//初始化页码
        } else {
            page.setPageNo(pageNo);
        }

        Page<Slider> sliderList = sliderService.pagedList(page);

        model.addAttribute("domainList", sliderList);


        return "admin/slider/list";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "admin/slider/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String doAdd(HttpServletRequest request) {

        FileItemStream fileStream = null;

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());         upload.setSizeMax(955360);

        Slider slider = new Slider();

        String fileName = null;
        FileItemIterator iterator = null;
        try {
            iterator = upload.getItemIterator(request);


            while (iterator.hasNext()) {

                fileStream = iterator.next();

                String name = fileStream.getFieldName();
                InputStream stream = fileStream.openStream();
                if (fileStream.isFormField()) {

                    BeanUtils.setProperty(slider, name, Streams.asString(stream, Constants.Default_SysEncoding));

                    continue;
                }

                if(org.springframework.util.StringUtils.isEmpty(fileStream.getName())){
                    continue;
                }

                String path = Constants.APP_REAL_PATH + "resources/img/uploads/" + fileStream.getName();

                FileUtils.copyInputStreamToFile(stream, new File(path));

                stream.close();

                fileName = fileStream.getName();

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if(!StringUtils.isEmpty(fileName)) {
            slider.setPicUrl(AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH) + "/resources/img/uploads/" + fileName);
        }
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
    public String doEdit(HttpServletRequest request) {

        Slider slider = new Slider();

        FileItemStream fileStream = null;

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());         upload.setSizeMax(955360);

        String fileName = null;
        FileItemIterator iterator = null;
        try {
            iterator = upload.getItemIterator(request);


            while (iterator.hasNext()) {

                fileStream = iterator.next();

                String name = fileStream.getFieldName();
                InputStream stream = fileStream.openStream();
                if (fileStream.isFormField()) {

                    BeanUtils.setProperty(slider, name, Streams.asString(stream, Constants.Default_SysEncoding));

                    continue;
                }

                if(org.springframework.util.StringUtils.isEmpty(fileStream.getName())){
                    continue;
                }

                String path = Constants.APP_REAL_PATH + "resources/img/uploads/" + fileStream.getName();

                FileUtils.copyInputStreamToFile(stream, new File(path));

                stream.close();

                fileName = fileStream.getName();

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if(!StringUtils.isEmpty(fileName)) {
            slider.setPicUrl(AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH) + "/resources/img/uploads/" + fileName);
        }
        sliderService.save(slider);

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

            sliderService.del(id);

        } catch (AdminException e) {

            ResponseCodesHelper.buildErrResponse(e, ajaxResponse);

        }

        return ajaxResponse;
    }

}
