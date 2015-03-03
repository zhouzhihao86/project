package com.xplore.web.dao;

import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.domain.Config;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/15.
 */
@Repository
public class ConfigDao extends HibernateBaseDao<Config, Integer> {

    public List<Config> refresh(Integer systemId) {

        String hql = "from Config where systemId = ? and recSt=1";

        return find(hql, systemId);

    }

    public void saveIpCnt(Integer ipCnt) {

        String hql = "update tbl_config set `value` = ? where `key` = ?";

        jdbcTemplate.update(hql, ipCnt, "total_cnt");

    }
}
