package com.xplore.web.interceptor;

import com.xplore.web.domain.IpCnt;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by damen on 2014/12/31.
 * 一个session算一个
 *
 */
public class IpIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String sessionId = httpServletRequest.getSession().getId();

        if(StringUtils.isEmpty(sessionId)){
            return true;
        }

        try {
            IpCnt.add(sessionId);
        }catch(Exception e){
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        modelAndView.getModel().put("ipCnt", IpCnt.getIpCnt());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
