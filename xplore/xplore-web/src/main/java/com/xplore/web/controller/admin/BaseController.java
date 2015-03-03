package com.xplore.web.controller.admin;

import com.xplore.web.vo.AdminSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
public class BaseController {


    @ModelAttribute("adminSession")
    public AdminSession getAdminSession(HttpSession session, Model model) {

        AdminSession adminSession = AdminSession.getCurrentAdmin(session);

        model.addAttribute("menu", adminSession.getMenu());

        model.addAttribute("adminInfo", adminSession.getAdmin());

        model.addAttribute("currentResource", adminSession.getCurrentResource());

        model.addAttribute("currentPerm", adminSession.getCurrentPerm());

        return adminSession;

    }

}
