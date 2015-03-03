package com.xplore.web.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by damen on 2014/12/20.
 */
@Entity
@Table(name = "tbl_news")
public class News {

    public static final Integer HAS_VIDEO = 1;
    public static final Integer HAS_NO_VIDEO = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    @Column(name = "has_video")
    private Integer hasVideo = 1;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "log_time")
    private String logTime;

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getDisplayDate(){

        return getLogTime();

    }

    public Integer getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Integer hasVideo) {
        this.hasVideo = hasVideo;
    }
}
