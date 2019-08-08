package com.crm.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author admin
 *
 */
public class MenuDto {

	private Integer menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单地址
	 */
	private String menuUrl;

	/**
	 * 主动创建
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date menuCreate;

	/**
	 * 被动更新
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date menuModified;

	/**
	 * 父ID
	 */
	private Integer menuParentid;

	public MenuDto() {
		super();
	}

	public MenuDto(Integer menuId, String menuName, String menuUrl, Date menuCreate, Date menuModified,
			Integer menuParentid) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuCreate = menuCreate;
		this.menuModified = menuModified;
		this.menuParentid = menuParentid;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Date getMenuCreate() {
		return menuCreate;
	}

	public void setMenuCreate(Date menuCreate) {
		this.menuCreate = menuCreate;
	}

	public Date getMenuModified() {
		return menuModified;
	}

	public void setMenuModified(Date menuModified) {
		this.menuModified = menuModified;
	}

	public Integer getMenuParentid() {
		return menuParentid;
	}

	public void setMenuParentid(Integer menuParentid) {
		this.menuParentid = menuParentid;
	}

	@Override
	public String toString() {
		return "MenuDto [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuCreate="
				+ menuCreate + ", menuModified=" + menuModified + ", menuParentid=" + menuParentid + "]";
	}

}
