package com.xplore.web.controller.admin;

import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.exception.AdminException;
import com.xplore.web.service.permission.LoginService;
import com.xplore.web.utils.RedirectUtils;
import com.xplore.web.vo.AdminSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by Dotar on 2015/3/11.
 */
@Controller
@RequestMapping(value="")
public class HomeController {

    @Autowired
    LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value ="welcome", method = RequestMethod.GET)
    public String welcome(Model model){

        return "welcome";
    }

    @RequestMapping(value = "permissionDeny", method = RequestMethod.GET)
    public String permissionDeny(Model model){

        return "permissionDeny";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, RedirectAttributes redirectAttribute, HttpSession httpSession
            , @RequestParam(value="username", required = false)String username
            , @RequestParam(value="password", required = false)String password){

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return RedirectUtils.addRedirectAttributes("welcome", redirectAttribute, ResponseCodes.KEY_LOGIN_AUTH_ERR);
        }

        AdminSession adminSession;
        try{
            adminSession = loginService.tryLogin(username, password);
        } catch (AdminException e){
            return RedirectUtils.addRedirectAttributes("welcome", redirectAttribute, e.getResponseCode());
        }

        adminSession.login(httpSession);

        model.addAttribute("menu", adminSession.getMenu());

        return adminSession.getLastUrl();
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession){

        AdminSession adminSession = AdminSession.getCurrentAdmin(httpSession);

        if(adminSession != null){
            adminSession.logout(httpSession);
        }

        return "redirect:welcome";
    }
}
