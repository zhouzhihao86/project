package com.xplore.web.job;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.domain.IpCnt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhouzhihao on 2014/11/4.
 */
public class FlushJob {

    private static final Logger logger = LoggerFactory.getLogger(FlushJob.class);

    @Autowired
    AdminConfig adminConfig;

    public void flush() {

        try {
            adminConfig.saveIpCnt(IpCnt.getIpCnt());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
