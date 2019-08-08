package com.crm.service;

import java.util.List;

import com.crm.pojo.RolePo;
import com.crm.pojo.UserPo;

public interface UserLoginService {
	
	
	
	public UserPo queryUserPo(String loginname);
	
	public List<String> queryUserRoleList(String loginname);

}
