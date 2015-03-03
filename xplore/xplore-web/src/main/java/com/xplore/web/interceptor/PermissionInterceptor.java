package com.xplore.web.interceptor;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.permission.Perm;
import com.xplore.web.domain.permission.Resource;
import com.xplore.web.vo.AdminSession;
import com.xplore.web.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by zhouzhihao on 2014/10/15.
 */
public class PermissionInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    private static final String LOGIN_URL = "/welcome";

    private static final String PERMISSION_DENY_URL = "/permissionDeny";

    private List<String> excludeMappings;

    private String baseLocation;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {

        String requestUri = request.getRequestURI();

        if (isExclude(requestUri)) {
            return true;
        }

        // 判断用户是否登陆
        if (!AdminSession.isLogin(request.getSession())) {
            logger.warn("user is not login[{}]", request.getSession().getId());
            return toLoginPage(response);

        }

        // 从session中获取当前admin
        AdminSession adminSession = AdminSession.getCurrentAdmin(request.getSession());

        String currentUri = getCurrentUri(request);

        logger.warn("currentResource {}", currentUri);

        // let it go
        if(currentUri.equals("index")){
            return true;
        }

        // 对resource访问进行权限检查
        Resource currentResource = getCurrentResourcePermVo(currentUri, adminSession);

        if (currentResource == null) {
            return redirect(response, PERMISSION_DENY_URL);
        }

        // 对resource下的该perm进行检查
        Perm perm = getCurrentPermInResourcePermVo(currentUri, currentResource, adminSession);

        // 如果没有找到perm，就再见
        if (perm == null) {
            return redirect(response, PERMISSION_DENY_URL);
        }

        adminSession.setCurrentUri(requestUri);

        adminSession.setCurrentResource(currentResource);
        adminSession.setCurrentPerm(perm);

        return true;
    }

    private String getCurrentUri(HttpServletRequest request) {

        String requestUrl = request.getRequestURL().toString();

        Integer jSessionIdIdx = requestUrl.indexOf(";jsessionid");

        if(jSessionIdIdx != -1){

            requestUrl = requestUrl.substring(0, jSessionIdIdx);

        }

        return requestUrl.replace(AdminConfig.get(AdminConfig.KEY_PROXY_LOCATION), "");

    }

    // 满足最长匹配原则
    private Resource getCurrentResourcePermVo(String currentUri, AdminSession adminSession) {

        Resource currentResource = null;

        Set<Resource> resourceSet = adminSession.getResources();

        for(Resource resource : resourceSet){

            String permittedUri = resource.getUri();

            if (StringUtils.startsWith(currentUri, permittedUri)) {

                if (currentResource == null || currentResource.getUri().length() < resource.getUri().length()) {

                    currentResource = resource;

                    break;

                }


            }
        }

        return currentResource;


    }

    private Perm getCurrentPermInResourcePermVo(String currentUri, Resource currentResource, AdminSession adminSession) {

        // 获取当前资源的权限列表,lazyLoad，直到使用后才加载
        if (currentResource.getPerms() == null) {

            return null;

        }

        Integer currentOperationIdx = currentUri.lastIndexOf("/");

        if(currentOperationIdx == -1){

            currentUri += "/list";

            currentOperationIdx = currentUri.lastIndexOf("/");

        }


        String currentOperation = currentUri.substring(currentOperationIdx + 1);

        for (Perm perm : currentResource.getPerms()) {

            if (currentOperation.equals(perm.getUri())) {

                return perm;

            }

        }

        return null;
    }


    private boolean redirect(HttpServletResponse response, String path) {
        try {
            response.sendRedirect(AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH) + path);
        } catch (IOException e) {
        }
        return false;
    }

    private boolean toLoginPage(HttpServletResponse response) {
        return redirect(response, LOGIN_URL);
    }

    private boolean isExclude(String requestURI) {
        for (String uri : excludeMappings) {
            if (requestURI.endsWith(uri)) {
                return true;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public List<String> getExcludeMappings() {
        return excludeMappings;
    }

    public void setExcludeMappings(List<String> excludeMappings) {
        this.excludeMappings = excludeMappings;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }
}
