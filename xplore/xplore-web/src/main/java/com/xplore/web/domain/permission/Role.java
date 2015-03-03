package com.xplore.web.domain.permission;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhouzhihao on 2014/10/15.
 */
@Entity
@Table(name = "tbl_role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tbl_role_resource",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="resource_id")})
    private Set<Resource> resources;

    @Column(name="rec_st")
    private int recSt;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
