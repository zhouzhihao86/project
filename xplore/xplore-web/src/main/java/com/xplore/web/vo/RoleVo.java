package com.xplore.web.vo;

import com.xplore.web.domain.permission.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouzhihao on 2014/11/20.
 */
public class RoleVo {

    private Integer id;

    private String name;

    private boolean active = false;

    public RoleVo(){};

    public RoleVo(Role role) {

        setId(role.getId());
        setName(role.getName());

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static List<RoleVo> toRoleVoList(List<Role> roleList) {

        List<RoleVo> roleVoList = new ArrayList<RoleVo>();

        if(roleList == null || roleList.size() == 0){
            return roleVoList;
        }

        for (Role role : roleList) {

            RoleVo vo = new RoleVo(role);

            roleVoList.add(vo);

        }

        return roleVoList;
    }
}
