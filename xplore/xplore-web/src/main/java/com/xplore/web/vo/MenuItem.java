package com.xplore.web.vo;

import com.xplore.web.domain.permission.Resource;

/**
 * Created by zhouzhihao on 2014/11/11.
 */
public class MenuItem {


    private String resourceName;
    private String resourceUri;

    public MenuItem(Resource vo) {
        this.resourceName = vo.getName();
        this.resourceUri = vo.getUri();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }
}
