package com.xplore.web.util;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberGenerator {

    private static final String PREFIX_PROTOPS = "pt";

    private static Object MUTEX = new Object();

    private static AtomicInteger atomicInt = new AtomicInteger();

    private static char ZERO = '0';

    private static Integer LEFT_PAD = 5;

    /**
     * 递增地产22位号码
     * 
     * @return 流水号
     */
    private static String incrementAndGet() {

        int num = atomicInt.getAndIncrement();

        if (atomicInt.get() >= 90000) {
            synchronized (MUTEX) {
                if (atomicInt.get() >= 9000) {
                    atomicInt.set(0);
                }
            }
        }

        return StringUtils.leftPad("" + num, LEFT_PAD, ZERO);
    }

    /**
     * 生成全局唯一number
     * 
     * @return
     */
    public static String generate() {
        StringBuffer sb = new StringBuffer(DateUtil.getDate(new Date(), DateUtil.DATE_FMT_YMDHMS));
        sb.append(incrementAndGet());
        return sb.toString();
    }

    public static String generateProtopsSelfMemberNumber(){
        return PREFIX_PROTOPS + generate();
    }
}
