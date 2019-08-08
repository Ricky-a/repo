package com.crm.pojo;

import java.util.Date;

/**
 * 
 * @author admin
 *
 */
public class MenuPo {

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
	private Date menuCreate;

	/**
	 * 被动更新
	 */
	private Date menuModified;

	/**
	 * integer
	 */
	private Long menuInteger;

	/**
	 * string
	 */
	private String menuString;

	/**
	 * 父ID
	 */
	private Integer menuParentid;

	public MenuPo() {
		super();
	}

	public MenuPo(Integer menuId, String menuName, String menuUrl, Date menuCreate, Date menuModified, Long menuInteger,
			String menuString, Integer menuParentid) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuCreate = menuCreate;
		this.menuModified = menuModified;
		this.menuInteger = menuInteger;
		this.menuString = menuString;
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

	public Long getMenuInteger() {
		return menuInteger;
	}

	public void setMenuInteger(Long menuInteger) {
		this.menuInteger = menuInteger;
	}

	public String getMenuString() {
		return menuString;
	}

	public void setMenuString(String menuString) {
		this.menuString = menuString;
	}

	public Integer getMenuParentid() {
		return menuParentid;
	}

	public void setMenuParentid(Integer menuParentid) {
		this.menuParentid = menuParentid;
	}

	@Override
	public String toString() {
		return "MenuPo [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuCreate="
				+ menuCreate + ", menuModified=" + menuModified + ", menuInteger=" + menuInteger + ", menuString="
				+ menuString + ", menuParentid=" + menuParentid + "]";
	}

}
