package com.crm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author admin
 *
 */
public class RolePo {
	
	private Integer roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 主动创建
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date roleCreate;

	/**
	 * 被动更新
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date roleModified;

	/**
	 * integer
	 */
	private Long roleInteger;

	/**
	 * string
	 */
	private String roleString;

	public RolePo() {
		super();
	}

	public RolePo(Integer roleId, String roleName, Date roleCreate, Date roleModified, Long roleInteger,
			String roleString) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCreate = roleCreate;
		this.roleModified = roleModified;
		this.roleInteger = roleInteger;
		this.roleString = roleString;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getRoleCreate() {
		return roleCreate;
	}

	public void setRoleCreate(Date roleCreate) {
		this.roleCreate = roleCreate;
	}

	public Date getRoleModified() {
		return roleModified;
	}

	public void setRoleModified(Date roleModified) {
		this.roleModified = roleModified;
	}

	public Long getRoleInteger() {
		return roleInteger;
	}

	public void setRoleInteger(Long roleInteger) {
		this.roleInteger = roleInteger;
	}

	public String getRoleString() {
		return roleString;
	}

	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	@Override
	public String toString() {
		return "RolePo [roleId=" + roleId + ", roleName=" + roleName + ", roleCreate=" + roleCreate + ", roleModified="
				+ roleModified + ", roleInteger=" + roleInteger + ", roleString=" + roleString + "]";
	}

}
