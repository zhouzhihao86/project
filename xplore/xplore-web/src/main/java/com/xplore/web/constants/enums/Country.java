package com.xplore.web.constants.enums;

import com.xplore.web.util.StringUtils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhouzhihao on 2015/3/16.
 */
public enum Country {

    england(1),america(2),china(3);

    private Integer countryId;

    Country(int i) {
        this.countryId = i;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public static Country parse(Integer op) {

        for (Country opEnum : values()) {
            if (opEnum.name().equals(op)) {
                return opEnum;
            }
        }
        return null;
    }

    public String display(String lan) {
        return getPlaceHolder(this, lan);
    }

    private String getPlaceHolder(Country key, String lan) {
        if(StringUtils.equals(lan, "en")){
            return ResourceBundle.getBundle("i18n/placeholder", Locale.ENGLISH).getString(key.name());
        }
        return ResourceBundle.getBundle("i18n/placeholder", Locale.CHINESE).getString(key.name());
    }

}
