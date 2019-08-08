package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.UserMapper;
import com.crm.dto.UserDto;
import com.crm.entity.Page;
import com.crm.pojo.UserPo;
import com.crm.service.UserService;
import com.crm.util.UIDtoFactory;
import com.crm.vo.ServerResponse;

/**
 * 
 * @author admin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public List<UserDto> queryUserList(Page page) {
		return UIDtoFactory.userDtoUI(mapper.queryUserList(page));
	}

	@Override
	public Integer queryCountUser() {
		return mapper.queryCountUser();
	}

	@Override
	public ServerResponse<UserPo> insertUser(UserPo user) {
		int i = mapper.insertUser(user);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		return ServerResponse.createByErrorMessage("添加失败");
	}

	@Override
	public ServerResponse<UserPo> saveUser(UserPo user) {
		int i = mapper.saveUser(user);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("修改成功");
		}
		return ServerResponse.createByErrorMessage("修改失败");
	}

	@Override
	public ServerResponse<UserPo> removeUser(UserPo user) {
		int i = mapper.removeUser(user);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		return ServerResponse.createByErrorMessage("删除失败");
	}

	@Override
	public Integer setPassword(UserPo user) {
		return mapper.setPassword(user);
	}

}
