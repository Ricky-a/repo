package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.crm.dao.MenuMapper;
import com.crm.dto.MenuDto;
import com.crm.entity.Page;
import com.crm.pojo.MenuPo;
import com.crm.service.MenuService;
import com.crm.util.UIDtoFactory;
import com.crm.util.UITreeFactory;
import com.crm.vo.ServerResponse;
import com.crm.vo.TreeVo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper mapper;

	@Override
	public List<MenuDto> queryMyParentMenu(Integer usercode) {
		return UIDtoFactory.menuDtoUI(mapper.queryMyParentMenu(usercode));
	}

	@Override
	public List<MenuDto> queryMyDetailMenu(Integer usercode, Integer parentcode) {
		return UIDtoFactory.menuDtoUI(mapper.queryMyDetailMenu(usercode, parentcode));
	}

	@Override
	public List<MenuDto> queryMenuList(Page page) {
		return UIDtoFactory.menuDtoUI(mapper.queryMenuList(page));
	}

	@Override
	public Integer queryCountMenu() {
		return mapper.queryCountMenu();
	}

	@Override
	public ServerResponse<MenuPo> updateMenu(MenuPo menu) {
		int i = mapper.updateMenu(menu);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("添加菜单成功");
		}
		return ServerResponse.createByErrorMessage("添加菜单失败");
	}

	@Override
	public ServerResponse<MenuPo> deleteMenu(Integer menuid) {
		int i = mapper.deleteMenu(menuid);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("删除菜单成功");
		}
		return ServerResponse.createByErrorMessage("删除菜单失败");
	}

	@Override
	public ServerResponse<MenuPo> insertMenu(MenuPo menu) {
		int i = mapper.insertMenu(menu);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("添加菜单成功");
		}
		return ServerResponse.createByErrorMessage("添加菜单失败");
	}

	@Override
	public List<MenuDto> queryNotMyMenu(String roleId) {
		return UIDtoFactory.menuDtoUI(mapper.queryNotMyMenu(roleId));
	}

	@Override
	public List<MenuDto> queryMyMenu(String roleId) {
		return UIDtoFactory.menuDtoUI(mapper.queryMyMenu(roleId));
	}

	@Override
	public ServerResponse<MenuDto> removeMyMenu(String roleId, String MenuId) {
		int i = mapper.removeMyMenu(roleId, MenuId);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("删除菜单成功");
		}
		return ServerResponse.createByErrorMessage("删除菜单失败");
	}

	@Override
	public ServerResponse<MenuDto> insertMyMenu(String roleId, String MenuId) {
		int i = mapper.insertMyMenu(roleId, MenuId);
		if (i == 1) {
			return ServerResponse.createBySuccessMessage("添加菜单成功");
		}
		return ServerResponse.createByErrorMessage("添加菜单失败");
	}

	@Override
	public Object queryTreeList() {
		System.out.println("UIDtoFactory.menuDtoUI(mapper.queryTreeList())=>"+UIDtoFactory.menuDtoUI(mapper.queryTreeList()));
		return UITreeFactory.reTreeJson(UIDtoFactory.menuDtoUI(mapper.queryTreeList()),true);
	}

	@Override
	public MenuDto queryMenuById(Integer menucode) {
		return UIDtoFactory.menuDtoUI(mapper.queryMenuById(menucode));
	}

	
}
