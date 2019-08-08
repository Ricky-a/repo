package com.crm.vo;

/**
 * 
 * @author admin
 *
 */
public class TreeData {

	private String url;

	private Integer weight;

	public TreeData() {
		super();
	}

	public TreeData(String url, Integer weight) {
		super();
		this.url = url;
		this.weight = weight;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
