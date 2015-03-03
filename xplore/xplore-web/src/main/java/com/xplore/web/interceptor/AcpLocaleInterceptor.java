package com.xplore.web.interceptor;

import com.xplore.web.constants.LocaleEnum;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by guowenchao on 2014-05-29.
 */
public class AcpLocaleInterceptor extends LocaleChangeInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws ServletException {
//        MDC.put("SID", request.getSession().getId());
        String newLocale = request.getLocale().toString();

        if (com.xplore.web.util.StringUtils.isBlank(newLocale)) {
            newLocale = "zh_CN";
        } else {
            newLocale = newLocale.replaceAll("-", "_");
        }

        Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if (locale == null) {
            locale = LocaleEnum.parseByLocale(StringUtils.parseLocaleString(newLocale)).getLocale();

            if (locale == Locale.CHINA) {
                locale = Locale.CHINESE;
            }

            if (locale == Locale.US) {
                locale = Locale.ENGLISH;
            }

            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        }

        if (newLocale != null) {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }
            localeResolver.setLocale(request, response, locale);
        }
        // Proceed in any case.
        return true;
    }

    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
//        request.setAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
//
//        Locale sessionLocale = (Locale) request.getSession().getAttribute(
//                SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
//        if (sessionLocale == null) {
//            sessionLocale = request.getLocale();
//        }
//        LocaleEnum localeEnum = LocaleEnum.parseByLocale(sessionLocale);
//
//        if(request.getAttribute("localeStr") == null) {
//            request.setAttribute("localeStr", localeEnum.getLocale().toString());
//        }

        // 设置当前系统时间
        request.setAttribute("currentTime",
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

        response.setHeader("P3P", "CP='IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT'");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);
    }
}
