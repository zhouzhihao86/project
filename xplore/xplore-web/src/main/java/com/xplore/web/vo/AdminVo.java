package com.xplore.web.vo;

import com.xplore.web.constants.enums.PlaceHolder;
import com.xplore.web.domain.permission.Admin;
import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.exception.AdminException;
import com.xplore.web.util.VerifyUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damen on 2014/11/21.
 */
public class AdminVo {

    private Integer id;
    private String username;
    private String realName;
    private String mobile;
    private Integer departmentId;
    private String roleIds;

    private String pwd;
    private String confirmedPwd;


    public AdminVo() {
    }

    ;

    private List<RoleVo> roles = new ArrayList<RoleVo>();


    public AdminVo(Admin admin) {
        setId(admin.getId());
        setRealName(admin.getRealName());
        setMobile(admin.getMobile());
        setUsername(admin.getUsername());


    }

    public AdminVo(Admin admin, List<RoleVo> roleVoList) {

        this(admin);

        setRoles(roleVoList);

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmedPwd() {
        return confirmedPwd;
    }

    public void setConfirmedPwd(String confirmedPwd) {
        this.confirmedPwd = confirmedPwd;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void validate(boolean validatePassword) throws AdminException {

        if (!VerifyUtils.verify(getUsername(), VerifyUtils.REGEX_BASE_USERNAME)) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.USERNAME.display());
        }

        if (!StringUtils.isEmpty(getRealName()) && getRealName().length() > 32) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.REALNAME.display());
        }

        if (!StringUtils.isEmpty(getMobile()) && !VerifyUtils.verify(getMobile(), VerifyUtils.REGEX_MOBILE)) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.MOBILE.display());
        }
        if (validatePassword) {

            if (!StringUtils.equals(getPwd(), getConfirmedPwd())) {
                throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.PASSWORD.display());
            }

        }

    }
}
