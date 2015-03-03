package com.xplore.web.utils;

import com.xplore.web.constants.ResponseCodes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by zhouzhihao on 2014/10/15.
 */
public class RedirectUtils {

    public static final String addRedirectAttributes(String page, RedirectAttributes redirectAttributes, String key) {
        String message = ResponseCodes.getMsg(key);
        redirectAttributes.addFlashAttribute("err-msg", message);
        return "redirect:" + page;
    }

}
