package com.xplore.web.dao.permission;

import com.xplore.web.domain.permission.Admin;
import com.xplore.web.util.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Repository
public class AdminDao extends HibernateBaseDao<Admin, Integer> {

    public Admin passwordOK(Integer id, String password) {

        String hql = "from Admin where id=? and password=?";

        List<Admin> admins = find(hql, id, password);

        if (admins.size() == 0) {

            return null;

        }

        return admins.get(0);
    }

    public Admin hit(String username, String password) {

        String hql = "from Admin where username=? and password=?";

        List<Admin> admins = find(hql, username, password);

        if (admins.size() == 0) {

            return null;

        }

        return admins.get(0);
    }

    public List<Admin> list() {

        String hql = "from Admin where recSt = 1";

        return find(hql);

    }
}
