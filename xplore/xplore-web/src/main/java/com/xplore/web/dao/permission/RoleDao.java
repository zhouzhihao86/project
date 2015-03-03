package com.xplore.web.dao.permission;

import com.xplore.web.domain.permission.Role;
import com.xplore.web.util.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Repository
public class RoleDao extends HibernateBaseDao<Role, Integer> {



    public List<Role> getRolesByAdminId(Integer id) {

        String sql = "select c.id as id, c.name as name from tbl_admin_role a, tbl_admin b, tbl_role c where b.id = a.admin_id and a.role_id = c.id and b.id = ?";

        return findBySql(sql, Role.class, id);
    }

    public List<Role> roleList() {

        String hql = "from Role where recSt = 1";

        return find(hql);
    }

    public List<Role> getRoleListIn(List<Integer> roleIdList) {

        String hql = "from Perm where id in (:roleIdList)";

        return findIn(hql, "roleIdList", roleIdList);

    }
}
