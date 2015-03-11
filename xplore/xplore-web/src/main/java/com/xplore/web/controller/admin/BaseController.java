package com.xplore.web.controller.admin;

import com.xplore.web.vo.AdminSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by Dotar on 2015/3/11.
 */
public class BaseController {

    @ModelAttribute("adminSession")
    public AdminSession getAdminSession(HttpSession httpSession, Model model){

        AdminSession adminSession = AdminSession.getCurrentAdmin(httpSession);

        model.addAttribute("menu", adminSession.getMenu());
        model.addAttribute("adminInfo", adminSession.getAdmin());
        model.addAttribute("currentResource", adminSession.getCurrentResource());
        model.addAttribute("currentPerm", adminSession.getCurrentPerm());

        return adminSession;
    }
}
