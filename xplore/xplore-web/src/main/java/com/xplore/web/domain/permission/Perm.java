package com.xplore.web.domain.permission;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by damen on 2014/10/15.
 * 领域模型：权限；
 * 1，权限不能独立于资源而存在，单独的权限没有意义，权限只有归属于resource才有意义。
 * 2，不存在根据权限获取资源的查找方式，因此不需要在perm模型中获取resource对象
 */
@Entity
@Table(name = "tbl_perm")
public class Perm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "uri")
    private String uri;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "resource_id")
    private Integer resourceId;

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
