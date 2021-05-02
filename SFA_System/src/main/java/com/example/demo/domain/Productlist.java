package com.example.demo.domain;

import javax.validation.constraints.NotBlank;

public class Productlist {
	private Long id;

	@NotBlank(message="商品名")
	private String product_name;
	@NotBlank(message="カテゴリー")
	private String category;
	private Integer regular_price;
	//@Pattern(regexp = "個|袋|箱")
	private String unit;
	private String maker;
	private String product_specification;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getRegular_price() {
		return regular_price;
	}
	public void setRegular_price(Integer regular_price) {
		this.regular_price = regular_price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getProduct_specification() {
		return product_specification;
	}
	public void setProduct_specification(String product_specification) {
		this.product_specification = product_specification;
	}
}
