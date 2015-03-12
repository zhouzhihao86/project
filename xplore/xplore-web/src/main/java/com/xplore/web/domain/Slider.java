package com.xplore.web.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dotar on 2015/3/12.
 */
@Entity
@Table(name = "tbl_slider")
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "plate_id")
    private Integer plateId;

    @Column(name = "big_url")
    private String bigUrl;

    @Column(name = "small_url")
    private String smallUrl;

    @Column(name = "brief_cn")
    private String briefChinese;

    @Column(name = "brief_en")
    private String briefEnglish;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public String getBigUrl() {
        return bigUrl;
    }

    public void setBigUrl(String bigUrl) {
        this.bigUrl = bigUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getBriefChinese() {
        return briefChinese;
    }

    public void setBriefChinese(String briefChinese) {
        this.briefChinese = briefChinese;
    }

    public String getBriefEnglish() {
        return briefEnglish;
    }

    public void setBriefEnglish(String briefEnglish) {
        this.briefEnglish = briefEnglish;
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
}
