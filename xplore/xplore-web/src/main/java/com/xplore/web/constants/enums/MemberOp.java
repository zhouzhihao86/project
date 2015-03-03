package com.xplore.web.constants.enums;

/**
 * Created by damen on 2014/11/23.
 */
public enum MemberOp {

    info, points, coupon;

    public static MemberOp parse(String op) {

        for (MemberOp opEnum : values()) {
            if (opEnum.name().equals(op)) {
                return opEnum;
            }
        }
        return null;
    }
}
