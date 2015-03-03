package com.xplore.web.service.permission;

import com.xplore.web.dao.permission.RoleDao;
import com.xplore.web.domain.permission.Resource;
import com.xplore.web.domain.permission.Role;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


/**
 * Created by damen on 2014/10/15.
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> roleList() {
        return roleDao.roleList();
    }


    public Set<Resource> getPermission(Integer roleId) {

        Role role = roleDao.get(roleId);

        Set<Resource> resources = role.getResources();

        // force hibernate to load resources
        Hibernate.initialize(resources);

        return resources;

    }


}
