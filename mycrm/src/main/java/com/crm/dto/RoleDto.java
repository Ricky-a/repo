package com.crm.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author admin
 *
 */
public class RoleDto {

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

	public RoleDto() {
		super();
	}

	public RoleDto(Integer roleId, String roleName, Date roleCreate, Date roleModified) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleCreate = roleCreate;
		this.roleModified = roleModified;
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

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", roleName=" + roleName + ", roleCreate=" + roleCreate + ", roleModified="
				+ roleModified + "]";
	}

}
