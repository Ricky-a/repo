package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.RoleMapper;
import com.crm.dto.RoleDto;
import com.crm.entity.Page;
import com.crm.pojo.RolePo;
import com.crm.service.RoleService;
import com.crm.util.UIDtoFactory;
import com.crm.vo.ServerResponse;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper mapper;

	@Override
	public List<RoleDto> queryRoleList(Page page) {
		return UIDtoFactory.roleDtoUI(mapper.queryRoleList(page));
	}

	@Override
	public Integer queryCountRole() {
		return mapper.queryCountRole();
	}

	@Override
	public List<RoleDto> queryNotMyRole(String userId) {
		return UIDtoFactory.roleDtoUI(mapper.queryNotMyRole(userId));
	}

	@Override
	public List<RoleDto> queryMyRole(String userId) {
		return UIDtoFactory.roleDtoUI(mapper.queryMyRole(userId));
	}

	@Override
	public ServerResponse<RoleDto> removeMyRole(String userId, String roleId) {
		int i = mapper.removeMyRole(userId, roleId);
		if(i==1){
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		return ServerResponse.createByErrorMessage("删除失败");
	}

	@Override
	public ServerResponse<RoleDto> insertMyRole(String userId, String roleId) {
		int i = mapper.insertMyRole(userId, roleId);
		if(i==1){
			return ServerResponse.createBySuccessMessage("添加成功");
		}
		return ServerResponse.createByErrorMessage("添加失败");
	}

	
	
	
	
	@Override
	public ServerResponse<RoleDto> insertRole(RolePo role) {
		int i = mapper.insertRole(role);
		if(i==1){
			return ServerResponse.createBySuccessMessage("添加角色成功");
		}
		return ServerResponse.createByErrorMessage("添加角色失败");
	}

	@Override
	public ServerResponse<RoleDto> updateRole(RolePo role) {
		int i = mapper.updateRole(role);
		if(i==1){
			return ServerResponse.createBySuccessMessage("修改角色成功");
		}
		return ServerResponse.createByErrorMessage("修改角色失败");
	}

	@Override
	public ServerResponse<RoleDto> deleteRole(String roleId) {
		int i = mapper.deleteRole(roleId);
		if(i==1){
			return ServerResponse.createBySuccessMessage("删除角色成");
		}
		return ServerResponse.createByErrorMessage("删除角色失败");
	}
	


}
