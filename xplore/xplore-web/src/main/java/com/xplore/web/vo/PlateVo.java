package com.xplore.web.vo;

import com.xplore.web.dao.MenuDao;
import com.xplore.web.domain.Menu;
import com.xplore.web.domain.PlateChinese;
import com.xplore.web.domain.PlateEnglish;
import com.xplore.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by 琳 on 2015/3/25.
 */
public class PlateVo {

    private Integer id;
    private Integer plateId;
    private String title;
    private String brief;
    private String content;
    private Integer weight;
    private Date createTime;

    private String enName;
    private String CnName;

    public PlateVo(MenuService menuService, Object plate, boolean useChineseFlags){
        if(useChineseFlags){

            PlateChinese plateChinese = (PlateChinese)plate;
            this.setId(plateChinese.getId());
            this.setPlateId(plateChinese.getPlateId());
            this.setTitle(plateChinese.getTitle());
            this.setBrief(plateChinese.getBrief());
            this.setContent(plateChinese.getContent());
            this.setWeight(plateChinese.getWeight());
            this.setCreateTime(plateChinese.getCreateTime());
        } else {

            PlateEnglish plateEnglish = (PlateEnglish)plate;
            this.setId(plateEnglish.getId());
            this.setPlateId(plateEnglish.getPlateId());
            this.setTitle(plateEnglish.getTitle());
            this.setBrief(plateEnglish.getBrief());
            this.setContent(plateEnglish.getContent());
            this.setWeight(plateEnglish.getWeight());
            this.setCreateTime(plateEnglish.getCreateTime());
        }

        Menu menu = menuService.getById(this.plateId);
        this.setEnName(menu.getEnName());
        this.setCnName(menu.getCnName());
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return CnName;
    }

    public void setCnName(String cnName) {
        CnName = cnName;
    }
}
