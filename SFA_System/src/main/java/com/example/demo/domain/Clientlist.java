package com.example.demo.domain;

import javax.validation.constraints.NotBlank;

public class Clientlist {
	private Long id;

	@NotBlank(message="顧客名")
	private String client_name;
	private String company_name;
	private String location;
	private String mail;
	private Integer phone_number;
	private Integer capital;
	public Integer getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	/*@Min(value=10, message="数量下限")
	@Max(value=10000, message="数量上限")
	private float price;

	@Size(max=50, message="vendor")
	private String vendor;

	private String test;*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


}
