package com.xplore.web.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by damen on 2014/12/31.
 */
public class IpCnt {

    private static Integer prevCnt = 0;

    private static Set<String> ip = new HashSet<String>();

    public static boolean exceed(){
        if(ip.size() > 500){
            return true;
        }
        return false;
    }

    public static void add(String ipStr){
        ip.add(ipStr);
    }

    public static Integer getIpCnt(){
        return ip.size() + prevCnt;
    }

    public static void clear(){
        ip.clear();
    }

    public static void recover(Integer cnt){
        prevCnt = cnt;
    }
}
