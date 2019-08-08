package com.crm.dao;

import java.util.List;


import com.crm.entity.Page;
import com.crm.pojo.RolePo;
import com.crm.pojo.UserPo;

/**
 * 
 * @author admin
 * 
 */
public interface UserLoginMapper {

	public UserPo queryUserPo(String loginname);
	
	public List<String> queryUserRoleList(String loginname);

}
