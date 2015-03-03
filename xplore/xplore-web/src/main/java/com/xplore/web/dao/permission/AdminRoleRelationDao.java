package com.xplore.web.dao.permission;

import com.xplore.web.domain.permission.AdminRoleRelation;
import com.xplore.web.util.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Repository
public class AdminRoleRelationDao extends HibernateBaseDao<AdminRoleRelation, Integer> {

    public void delAdminRoles(Integer adminId) {

        String hql = "delete from AdminRoleRelation where adminId = ?";

        update(hql, adminId);

    }

    public void batchUpdate(List<Object[]> obj) {

        String sql = "insert into tbl_admin_role (admin_id, role_id, rec_st) values (?, ?, ?)";

        batchUpdate(sql, obj);

    }
}
