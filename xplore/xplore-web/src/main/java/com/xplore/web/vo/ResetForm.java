package com.xplore.web.vo;

import com.xplore.web.util.StringUtils;

/**
 * Created by damen on 2014/11/23.
 */
public class ResetForm {

    private Integer id;
    private String origPwd;
    private String newPwd;
    private String confirmedPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigPwd() {
        return origPwd;
    }

    public void setOrigPwd(String origPwd) {
        this.origPwd = origPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmedPwd() {
        return confirmedPwd;
    }

    public void setConfirmedPwd(String confirmedPwd) {
        this.confirmedPwd = confirmedPwd;
    }

    public boolean checkIdentical() {
        if(StringUtils.equals(getNewPwd(), getConfirmedPwd())){
            return true;
        }
        return false;
    }
}
