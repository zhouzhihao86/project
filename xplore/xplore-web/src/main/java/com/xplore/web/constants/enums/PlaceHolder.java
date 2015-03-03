package com.xplore.web.constants.enums;

import java.util.ResourceBundle;

public enum PlaceHolder {

    USERNAME, REALNAME, MOBILE, EXPIREDTIME, ADDRESS, EMAIL, POINTS, PLATENUMBER, PASSWORD;

    public String display() {
        return getPlaceHolder(this.name());
    }

    private String getPlaceHolder(String key) {
        return ResourceBundle.getBundle("i18n/placeholder").getString(key);
    }
}