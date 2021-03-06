package com.xplore.web.domain;

import com.xplore.web.constants.enums.Country;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dotar on 2015/3/12.
 */

@Entity
@Table(name = "tbl_campus_en")
public class CampusEnglish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "title")
    private String title;

    @Column(name = "profile")
    private String profile;

    @Column(name = "facts")
    private String facts;

    @Column(name = "curriculum")
    private String curriculum;

    @Column(name = "img")
    private String img;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "create_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName(){
        Country country = Country.parse(this.countryId);
        if(country ==null)
            return "";
        else
            return country.display("en");
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}