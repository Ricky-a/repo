package com.crm.dao;

import java.util.List;


import com.crm.entity.Page;
import com.crm.pojo.UserPo;

/**
 * 
 * @author admin
 * 
 */
public interface UserMapper {

	/**
	 * 分页查询USER表数据
	 * @param page
	 * @return
	 */
	public List<UserPo> queryUserList(Page page);
	
	/**
	 * 查询USER表总数
	 * @return
	 */
	public Integer queryCountUser();
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public Integer insertUser (UserPo user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public Integer saveUser(UserPo user);
	
	/**
	 * 删除用户
	 * 设置用户为失效数据
	 * @param user
	 * @return
	 */
	public Integer removeUser(UserPo user);
	
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public Integer setPassword(UserPo user);

}
