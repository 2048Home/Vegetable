package com.example.bean;

import java.io.Serializable;

public class Good implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -950366878206618723L;
	private  String goodName;
	private String goodPrice;
	private String goodWeight;
	private String goodImgPath;
	private String onBoxWeight;
	public String getOnBoxWeight() {
		return onBoxWeight;
	}
	public void setOnBoxWeight(String onBoxWeight) {
		this.onBoxWeight = onBoxWeight;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodWeight() {
		return goodWeight;
	}
	public void setGoodWeight(String goodWeight) {
		this.goodWeight = goodWeight;
	}
	public String getGoodImgPath() {
		return goodImgPath;
	}
	public void setGoodImgPath(String goodImgPath) {
		this.goodImgPath = goodImgPath;
	}
}
