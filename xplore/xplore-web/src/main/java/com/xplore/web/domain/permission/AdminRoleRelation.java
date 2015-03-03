package com.xplore.web.domain.permission;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by damen on 2014/10/15.
 */
@Entity
@Table(name = "tbl_admin_role")
public class AdminRoleRelation{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "role_id")
    private Integer roleId;


    @Column(name="rec_st")
    private int recSt;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public int getRecSt() {
        return recSt;
    }

    public void setRecSt(int recSt) {
        this.recSt = recSt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
