package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.UserLoginMapper;
import com.crm.pojo.UserPo;
import com.crm.service.UserLoginService;

/**
 * 
 * @author admin
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginMapper mapper;

	@Override
	public UserPo queryUserPo(String loginname) {
		return mapper.queryUserPo(loginname);
	}

	@Override
	public List<String> queryUserRoleList(String loginname) {
		return mapper.queryUserRoleList(loginname);
	}

	
}
