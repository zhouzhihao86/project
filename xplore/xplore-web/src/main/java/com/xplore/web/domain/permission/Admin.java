package com.xplore.web.domain.permission;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zhouzhihao on 2014/10/14.
 */
@Entity
@Table(name = "tbl_admin")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="real_name")
    private String realName;

    @Column(name="mobile")
    private String mobile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tbl_admin_role",joinColumns={@JoinColumn(name="admin_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
    private List<Role> roles;

    @Column(name="rec_st")
    private int recSt;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}