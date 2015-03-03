package com.xplore.web.domain.permission;

import javax.persistence.*;
import java.util.*;

/**
 * Created by damen on 2014/10/15.
 */
@Entity
@Table(name = "tbl_resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uri")
    private String uri;

    @Column(name = "desc")
    private String desc;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name="rec_st")
    private int recSt;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @OneToMany(mappedBy = "resourceId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Perm> perms = new ArrayList<Perm>();

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Perm> getPerms() {
        return perms;
    }

    public void setPerms(List<Perm> perms) {
        this.perms = perms;
    }
}
