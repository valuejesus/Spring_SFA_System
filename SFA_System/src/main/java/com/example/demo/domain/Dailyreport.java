package com.example.demo.domain;


import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class Dailyreport {
	private Long id;

	//@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateandtime;
	@NotBlank(message="担当者")
	private String person_in_charge;
	private String activitytime;
	private String activitycontent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(Date dateandtime) {
		this.dateandtime = dateandtime;
	}
	public String getPerson_in_charge() {
		return person_in_charge;
	}
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}
	public String getActivitytime() {
		return activitytime;
	}
	public void setActivitytime(String activitytime) {
		this.activitytime = activitytime;
	}
	public String getActivitycontent() {
		return activitycontent;
	}
	public void setActivitycontent(String activitycontent) {
		this.activitycontent = activitycontent;
	}
}