package com.crm.service;

import java.util.List;


import com.crm.dto.UserDto;
import com.crm.entity.Page;
import com.crm.pojo.UserPo;
import com.crm.vo.ServerResponse;

/**
 * 
 * @author admin
 *
 */
public interface UserService {
	
	/**
	 * 分页查询USER表数据
	 * @param page
	 * @return
	 */
	public List<UserDto> queryUserList(Page page);
	
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
	public ServerResponse<UserPo> insertUser (UserPo user);
	
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public ServerResponse<UserPo> saveUser(UserPo user);
	
	
	/**
	 * 删除用户
	 * 设置用户为失效数据
	 * @param user
	 * @return
	 */
	public ServerResponse<UserPo> removeUser(UserPo user);
	
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public Integer setPassword(UserPo user);
}
