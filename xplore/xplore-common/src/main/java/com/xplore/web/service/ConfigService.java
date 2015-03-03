package com.xplore.web.service;

import com.xplore.web.dao.ConfigDao;
import com.xplore.web.domain.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/15.
 */

@Service
@Transactional
public class ConfigService {

    @Autowired
    ConfigDao configDao;


    public List<Config> refresh(Integer systemId) {

        return configDao.refresh(systemId);

    }


    public void save(Config config) {
        configDao.save(config);
    }

    public void saveIpCnt(Integer ipCnt) {
        configDao.saveIpCnt(ipCnt);
    }
}
