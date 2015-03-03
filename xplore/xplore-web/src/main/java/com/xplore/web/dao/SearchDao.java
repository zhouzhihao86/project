package com.xplore.web.dao;

import com.xplore.web.domain.Search;
import com.xplore.web.util.HibernateBaseDao;
import com.xplore.web.util.Page;
import org.springframework.stereotype.Repository;

/**
 * Created by damen on 2014/12/20.
 */
@Repository
public class SearchDao extends HibernateBaseDao<Search, Integer> {

    public Page<Search> pagedList(Page<Search> page, String content) {

        String sql = "select id,  title,  create_time, 'achieve' as url " +
                "from tbl_achieve t " +
                "where title like '%__S__%' " +
                "union all " +
                "select id,  title,  create_time, 'news' as url " +
                "from tbl_news b " +
                "where title like '%__S__%' " +
                "union all " +
                "select id,  title,  create_time, 'culture' as url " +
                "from tbl_culture b " +
                "where title like '%__S__%' " +
                "union all " +
                "select id,  title,  create_time, 'jianshe' as url " +
                "from tbl_jianshe b " +
                "where title like '%__S__%' " +
                "union all " +
                "select id,  title,  create_time, 'picnews' as url " +
                "from tbl_picnews b " +
                "where title like '%__S__%' " +
                "union all " +
                "select id,  title,  create_time, 'service' as url " +
                "from tbl_service b " +
                "where title like '%__S__%' ";

        sql = sql.replace("__S__", content);

        return findBySql(page, Search.class, sql);

    }

    public int getTotalCount(String content) {

        String sql = "select sum(a) from ( " +
                "select count(t.id) a from tbl_achieve t where t.title like '%__S__%' " +
                "union all  " +
                "select count(n.id) a from tbl_news n where n.title like '%__S__%' " +
                "union all  " +
                "select count(c.id) a from tbl_culture c where c.title like '%__S__%' " +
                "union all  " +
                "select count(j.id) a from tbl_jianshe j where j.title like '%__S__%' " +
                "union all  " +
                "select count(p.id) a from tbl_picnews p where p.title like '%__S__%' " +
                "union all  " +
                "select count(s.id) a from tbl_service s where s.title like '%__S__%' " +
                ") cc";

        sql = sql.replace("__S__", content);

        return findCountBySql(sql);

    }
}
