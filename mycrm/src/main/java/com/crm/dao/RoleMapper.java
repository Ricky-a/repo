package com.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.entity.Page;
import com.crm.pojo.RolePo;

/**
 * 
 * @author admin
 *
 */
public interface RoleMapper {

	/**
	 * 分页查询Role表数据
	 * 
	 * @param page
	 * @return
	 */
	public List<RolePo> queryRoleList(Page page);

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
	public  Integer insertRole(RolePo role);
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public  Integer updateRole(RolePo role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	public Integer deleteRole(String roleId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 查询用户未拥有的角色
	 * @param userId
	 * @return
	 */
	public List<RolePo> queryNotMyRole(String userId);
	
	/**
	 * 查询用户已拥有的角色
	 * @param userId
	 * @return
	 */
	public List<RolePo> queryMyRole(String userId);
	
	/**
	 * 删除用户拥有的角色
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public Integer removeMyRole(@Param("userId")String userId,@Param("roleId")String roleId);
	
	/**
	 * 添加用户角色
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public Integer insertMyRole(@Param("userId")String userId,@Param("roleId")String roleId);
	

}
