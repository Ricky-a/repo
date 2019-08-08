package com.crm.service;

import java.util.List;


import com.crm.dto.RoleDto;
import com.crm.entity.Page;
import com.crm.pojo.RolePo;
import com.crm.vo.ServerResponse;

public interface RoleService {
	
	
	
	/**
	 * 分页查询Role表数据
	 * 
	 * @param page
	 * @return
	 */
	public List<RoleDto> queryRoleList(Page page);

	/**
	 * 查询Role表总数
	 * 
	 * @return
	 */
	public Integer queryCountRole();
	

	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public ServerResponse<RoleDto> insertRole(RolePo role);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public ServerResponse<RoleDto> updateRole(RolePo role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	public ServerResponse<RoleDto> deleteRole(String roleId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 查询用户未拥有的角色
	 * @param userId
	 * @return
	 */
	public List<RoleDto> queryNotMyRole(String userId);
	
	
	/**
	 * 查询用户已拥有的角色
	 * @param userId
	 * @return
	 */
	public List<RoleDto> queryMyRole(String userId);
	
	
	/**
	 * 删除用户拥有的角色
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public ServerResponse<RoleDto> removeMyRole(String userId,String roleId);
	
	/**
	 * 添加用户角色
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public ServerResponse<RoleDto> insertMyRole(String userId,String roleId);
	
	
	
	

	
	
	
	
	

}
