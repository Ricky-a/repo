package com.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.dto.MenuDto;
import com.crm.entity.Page;
import com.crm.pojo.MenuPo;
import com.crm.vo.ServerResponse;
import com.crm.vo.TreeVo;
/**
 * 
 * @author admin
 *
 */
public interface MenuService {

	/**
	 * 查询用户的父级菜单
	 * @param usercode
	 * @return
	 */
	List<MenuDto> queryMyParentMenu(@Param("usercode")Integer usercode);
	
	
	/**
	 * 查询用户子级菜单
	 * @param usercode
	 * @param parentcode
	 * @return
	 */
	List<MenuDto> queryMyDetailMenu(@Param("usercode")Integer usercode,@Param("parentcode")Integer parentcode);

	/**
	 * 分页查询menu表数据
	 * @param page
	 * @return
	 */
	List<MenuDto> queryMenuList(Page page);
	
	/**
	 * 查询menu表总数
	 * @return
	 */
	Integer queryCountMenu();
	
	
	
	ServerResponse<MenuPo> updateMenu(MenuPo menu);
	
	ServerResponse<MenuPo> deleteMenu(Integer menuid);
	
	ServerResponse<MenuPo> insertMenu(MenuPo menu);
	
	
	/**
	 * 查询所有菜单数据
	 * @return
	 */
	Object queryTreeList();
	
	/**
	 * 根据Id查询菜单
	 * @return
	 */
	MenuDto queryMenuById(Integer menucode);
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 查询角色未拥有的菜单
	 * @param roleId
	 * @return
	 */
	List<MenuDto> queryNotMyMenu(String roleId);
	
	/**
	 * 查询角色已拥有的菜单
	 * @param roleId
	 * @return
	 */
	List<MenuDto> queryMyMenu(String roleId);
	
	/**
	 * 删除角色已拥有的菜单
	 * @param roleId
	 * @param MenuId
	 * @return
	 */
	ServerResponse<MenuDto> removeMyMenu(@Param("roleId")String roleId,@Param("menuId")String menuId);
	
	/**
	 * 添加角色未拥有的菜单
	 * @param roleId
	 * @param MenuId
	 * @return
	 */
	ServerResponse<MenuDto> insertMyMenu(@Param("roleId")String roleId,@Param("menuId")String menuId);
	

}
