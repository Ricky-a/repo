package com.crm.web;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.crm.dto.MenuDto;
import com.crm.dto.RoleDto;
import com.crm.dto.UserDto;
import com.crm.entity.Page;
import com.crm.pojo.MenuPo;
import com.crm.service.MenuService;
import com.crm.util.DataUtil;
import com.crm.util.UITreeFactory;
import com.crm.vo.ServerResponse;

@Controller
@RequestMapping("/menu")
public class MenuController {


	@Autowired
	private MenuService menuService;

	
	/**
	 * 手风琴导航栏父模块
	 * 
	 * @return
	 */
	@RequestMapping(value = "searchParentMenu.do", produces = "application/json;charset=utf-8")
	private @ResponseBody Object searchParentMenu(HttpServletRequest request) {
		UserDto user = (UserDto) request.getSession().getAttribute("user");
		
		JSONArray jsonArray = new JSONArray();
		List<MenuDto> menulist = new ArrayList<MenuDto>();
		try {
			List<MenuDto> rolemenulist = menuService.queryMyParentMenu(Integer.valueOf("1"));
			menulist.addAll(rolemenulist);
			jsonArray = UITreeFactory.reTreeJson(menulist, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	
	/**
	 * 手风琴导航子模块
	 * 
	 * @return
	 */
	@RequestMapping(value = "searchDetailMenu.do", produces = "application/json;charset=utf-8")
	private @ResponseBody Object searchDetailMenu(HttpServletRequest request,@RequestBody MenuDto menu) {
		UserDto user = (UserDto) request.getSession().getAttribute("user");
		JSONArray jsonArray = new JSONArray();
		try {
			List<MenuDto> menulist = menuService.queryMyDetailMenu(Integer.valueOf("1"), menu.getMenuId());
			jsonArray = UITreeFactory.reTreeJson(menulist, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	
	/**
	 * (废弃)
	 * 查询菜单数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryMenuList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> queryMenuList(HttpServletRequest request) {

		/*** 获取当前页*/
		int page = Integer.valueOf(request.getParameter("page") == null ? "1" : request.getParameter("page"));
		/*** 获取每页显示的条数*/
		int rows = Integer.valueOf(request.getParameter("rows") == null ? "10" : request.getParameter("rows"));

		/*** 返回数据*/
		@SuppressWarnings("serial")
		Map<String, Object> returnMap = new HashMap<String, Object>(16) {
			{
				/*** 存放总数*/
				put("total", menuService.queryCountMenu());
				/*** 存放每页的数据*/
				put("rows", menuService.queryMenuList(new Page(page, rows)));
			}
		};
		return returnMap;
	}
	
	/**
	 * 模块管理页面查询功能
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "queryTreeList", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryTreeList(HttpServletRequest request) {
		System.out.println("menuService.queryTreeList()==>"+menuService.queryTreeList());
		return menuService.queryTreeList();
	}
	
	
	/**
	 * 根据菜单Id查询菜单
	 * @param request
	 * @param menucode
	 * @return
	 */
	@RequestMapping(value = "queryMenuById", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryMenuById(HttpServletRequest request,Integer menucode) {
		System.out.println(menuService.queryMenuById(menucode));
		return menuService.queryMenuById(menucode);
	}
	
	/**
	 * 修改菜单
	 * @param request
	 * @param menuDto
	 * @return
	 */
	@RequestMapping(value = "saveMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<MenuPo> saveMenu(HttpServletRequest request,MenuPo menu) {
		menu.setMenuModified(DataUtil.renewDate());
		return menuService.updateMenu(menu);
	}
	
	/**
	 * 添加菜单
	 * @param request
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "insertMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<MenuPo> insertMenu(HttpServletRequest request,MenuPo menu) {
		menu.setMenuCreate(DataUtil.renewDate());
		return menuService.insertMenu(menu);
	}
	
	
	@RequestMapping(value = "deleteMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<MenuPo> deleteMenu(HttpServletRequest request,Integer menuId) {
		System.out.println("menuId=>"+menuId);
		return menuService.deleteMenu(menuId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 在角色页面对角色设置菜单
	 * @param request
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "queryNotMyMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryNotMyMenu(HttpServletRequest request,String roleId) {
		return menuService.queryNotMyMenu(roleId);
	}
	
	@RequestMapping(value = "queryMyMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody Object queryMyMenu(HttpServletRequest request,String roleId) {
		return menuService.queryMyMenu(roleId);
	}
	
	@RequestMapping(value = "insertMyMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<MenuDto> insertMyMenu(HttpServletRequest request,String roleId,String menuId) {
		return menuService.insertMyMenu(roleId, menuId);
	}
	
	@RequestMapping(value = "removeMyMenu", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<MenuDto> removeMyMenu(HttpServletRequest request,String roleId,String menuId) {
		return menuService.removeMyMenu(roleId, menuId);
	}
	
	
	
	
	
	


}
