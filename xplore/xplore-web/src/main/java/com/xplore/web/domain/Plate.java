package com.xplore.web.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_plate")
public class Plate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="plate_id")
	private Integer plate_id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="brief")
	private String brief;
	
	@Column(name="url")
	private String url;
	
	@Column(name="content")
	private String content;
	
	@Column(name="weight")
	private Integer weight;
	
	@Column(name="create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlate_id() {
		return plate_id;
	}

	public void setPlate_id(Integer plate_id) {
		this.plate_id = plate_id;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
}
