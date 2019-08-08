package com.crm.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.dto.RoleDto;
import com.crm.entity.Page;
import com.crm.pojo.RolePo;
import com.crm.service.RoleService;
import com.crm.util.DataUtil;
import com.crm.vo.ServerResponse;

/**
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "queryRoleList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> queryRoleList(HttpServletRequest request) {

		/*** 获取当前页*/
		int page = Integer.valueOf(request.getParameter("page") == null ? "1" : request.getParameter("page"));
		/*** 获取每页显示的条数*/
		int rows = Integer.valueOf(request.getParameter("rows") == null ? "10" : request.getParameter("rows"));

		/*** 返回数据*/
		@SuppressWarnings("serial")
		Map<String, Object> returnMap = new HashMap<String, Object>(16) {
			{
				/*** 存放总数*/
				put("total", roleService.queryCountRole());
				/*** 存放每页的数据*/
				put("rows", roleService.queryRoleList(new Page(page, rows)));
			}
		};
		return returnMap;
	}
	
	
	
	
	@RequestMapping(value = "insertRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Object insertRole(HttpServletRequest request,@RequestBody RolePo role) {
		role.setRoleCreate(DataUtil.renewDate());
		role.setRoleModified(DataUtil.renewDate());
		return roleService.insertRole(role);
	}
	
	@RequestMapping(value = "updateRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Object updateRole(HttpServletRequest request,@RequestBody RolePo role) {
		role.setRoleModified(DataUtil.renewDate());
		return roleService.updateRole(role);
	}
	
	@RequestMapping(value = "deleteRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Object deleteRole(HttpServletRequest request,String roleId) {
		return roleService.deleteRole(roleId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "queryMyRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryMyRole(HttpServletRequest request,String userId) {
		return roleService.queryMyRole(userId);
	}
	
	@RequestMapping(value = "queryNotMyRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryNotMyRole(HttpServletRequest request,String userId) {
		return roleService.queryNotMyRole(userId);
	}
	
	@RequestMapping(value = "removeMyRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<RoleDto> removeMyRole(HttpServletRequest request,String userId,String roleId) {
		return roleService.removeMyRole(userId, roleId);
	}
	
	@RequestMapping(value = "insertMyRole.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<RoleDto> insertMyRole(HttpServletRequest request,String userId,String roleId) {
		return roleService.insertMyRole(userId, roleId);
	}
	
	

}
