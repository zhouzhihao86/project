package com.xplore.web.constants;

import com.xplore.web.domain.Config;
import com.xplore.web.domain.IpCnt;
import com.xplore.web.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouzhihao on 2014/10/15.
 */
public class AdminConfig implements ApplicationListener<ContextRefreshedEvent> {

    public static final String KEY_CONTEXT_PATH = "context_path";
    public static final String KEY_PAGE_SIZE = "page_size";
    public static final String KEY_WEB_PAGE_SIZE = "web_page_size";
    public static final String KEY_PROXY_LOCATION = "proxy_location";
    public static final String KEY_TOTAL_CNT = "total_cnt";
    public static final String KEY_FILE_UPLOAD_PATH = "fileUpload_location";

    private Integer systemId;

    private static Map<String, String> inMemoryConfig = new HashMap<String, String>();

    @Autowired
    ConfigService configService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {

            if (event instanceof ContextRefreshedEvent) {

                doLoad();

            }

        }

    }

    private void doLoad() {
        List<Config> configs = configService.refresh(systemId);

        for (Config config : configs) {

            inMemoryConfig.put(config.getKey(), config.getValue());

        }

        IpCnt.recover(AdminConfig.getInt(AdminConfig.KEY_TOTAL_CNT));
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public static String get(String key) {
        return inMemoryConfig.get(key);
    }

    public static Integer getInt(String keyPageNo) {
        return Integer.parseInt(get(keyPageNo));
    }

    public void saveIpCnt(Integer ipCnt) {

        configService.saveIpCnt(ipCnt);


    }
}
