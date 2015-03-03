package com.xplore.web.vo;

import com.xplore.web.domain.permission.Perm;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damen on 2014/10/15.
 */
public class ResourcePermVo {

    private Integer resourceId;

    private String resourceName;

    private String resourceUri;

    private String plainPerms;

    private String parentResourceName;

    private List<Integer> permIdList;

    private List<Perm> permList;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getPlainPerms() {
        return plainPerms;
    }

    public void setPlainPerms(String plainPerms) {
        this.plainPerms = plainPerms;
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

    public List<Perm> getPermList() {
        return permList;
    }

    public void setPermList(List<Perm> permList) {
        this.permList = permList;
    }


    public List<Integer> getPermIdList() {
        return permIdList;
    }

    public void setPermIdList(List<Integer> permIdList) {
        this.permIdList = permIdList;
    }

    public void toPermIdList(){

        if(StringUtils.isEmpty(this.getPlainPerms())){
            return;
        }

        String[] ret = this.getPlainPerms().split(",");

        List<Integer> permIdList = new ArrayList<Integer>();
        for(String perm : ret){
            permIdList.add(Integer.parseInt(perm));
        }

        setPermIdList(permIdList);

    }

    public void mergePerm(List<Integer> permIdList) {

        getPermIdList().addAll(permIdList);


    }

    public String getParentResourceName() {
        return parentResourceName;
    }

    public void setParentResourceName(String parentResourceName) {
        this.parentResourceName = parentResourceName;
    }
}
