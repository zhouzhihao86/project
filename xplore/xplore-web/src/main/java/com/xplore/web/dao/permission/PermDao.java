package com.xplore.web.dao.permission;

import com.xplore.web.domain.permission.Perm;
import com.xplore.web.util.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Repository
public class PermDao extends HibernateBaseDao<Perm, Integer> {


    public List<Perm> getPermList(List<Integer> permIdList) {

        String hql = "from Perm where id in (:permIdList)";

        return findIn(hql, "permIdList", permIdList);

    }
}
