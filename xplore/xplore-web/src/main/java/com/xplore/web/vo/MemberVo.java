package com.xplore.web.vo;

import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.constants.enums.PlaceHolder;
import com.xplore.web.exception.AdminException;
import com.xplore.web.util.DateUtil;
import com.xplore.web.util.VerifyUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by zhouzhihao on 2014/11/24.
 */
public class MemberVo {

    private String memberNumber;
    private String plateNumber;
    private Integer currentPoints;
    private String weixinId;
    private Integer memberType;
    private String expiredTime;
    private String realName;
    private String email;
    private String mobile;
    private String address;
    private Integer id;

    public void validate() throws AdminException {

        Date date = DateUtil.parseDate(expiredTime, DateUtil.DATE_FMT_DISPLAY2);
        if (date == null) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.EXPIREDTIME.display());
        }
        if (!StringUtils.isEmpty(getRealName()) && getRealName().length() > 32) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.REALNAME.display());
        }
        if (!StringUtils.isEmpty(getMobile()) && !VerifyUtils.verify(getMobile(), VerifyUtils.REGEX_MOBILE)) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.MOBILE.display());
        }
        if (!StringUtils.isEmpty(getAddress()) && address.length() > 256) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.ADDRESS.display());
        }
        if (!StringUtils.isEmpty(getEmail()) && !VerifyUtils.verify(getMobile(), VerifyUtils.REGEX_EMAIL)) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.EMAIL.display());
        }
        if (getCurrentPoints() == null || getCurrentPoints() > 999999) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.POINTS.display());
        }
        if (!StringUtils.isEmpty(getPlateNumber()) && getPlateNumber().length() > 32) {
            throw new AdminException(ResponseCodes.KEY_PARAMS_ERROR, PlaceHolder.PLATENUMBER.display());
        }
    }


    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
