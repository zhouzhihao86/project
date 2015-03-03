package com.xplore.web.domain;

import com.xplore.web.util.DateUtil;

import java.util.Date;

/**
 * Created by damen on 2014/12/27.
 */
public class Search {

    private Integer id;

    private String title;

    private Date create_time;

    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


    public String getDisplayDate(){

        return DateUtil.getDate(getCreate_time(), DateUtil.DATE_FMT_DISPLAY2);

    }
}
