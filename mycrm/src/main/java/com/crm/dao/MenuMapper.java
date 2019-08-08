package com.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.entity.Page;
import com.crm.pojo.MenuPo;

/**
 * 
 * @author admin
 *
 */
public interface MenuMapper {

	
	/**
	 * 查询用户的父级菜单
	 * @param usercode
	 * @return
	 */
	List<MenuPo> queryMyParentMenu(@Param("usercode")Integer usercode);
	
	
	/**
	 * 查询用户子级菜单
	 * @param usercode
	 * @param parentcode
	 * @return
	 */
	List<MenuPo> queryMyDetailMenu(@Param("usercode")Integer usercode,@Param("parentcode")Integer parentcode);
	
	/**
	 * 分页查询menu表数据
	 * @param page
	 * @return
	 */
	List<MenuPo> queryMenuList(Page page);
	
	/**
	 * 查询menu表总数
	 * @return
	 */
	Integer queryCountMenu();
	
	
	Integer updateMenu(MenuPo menu);
	
	Integer deleteMenu(Integer menuid);
	
	Integer insertMenu(MenuPo menu);
	
	
	
	
	/**
	 * 查询所有菜单数据
	 * @return
	 */
	List<MenuPo> queryTreeList();
	
	/**
	 * 根据Id查询菜单
	 * @return
	 */
	MenuPo queryMenuById(Integer menucode);
	
	
	
	/**
	 * 查询角色未拥有的菜单
	 * @param roleId
	 * @return
	 */
	List<MenuPo> queryNotMyMenu(String roleId);
	
	/**
	 * 查询角色已拥有的菜单
	 * @param roleId
	 * @return
	 */
	List<MenuPo> queryMyMenu(String roleId);
	
	/**
	 * 删除角色已拥有的菜单
	 * @param roleId
	 * @param MenuId
	 * @return
	 */
	Integer removeMyMenu(@Param("roleId")String roleId,@Param("menuId")String menuId);
	
	/**
	 * 添加角色未拥有的菜单
	 * @param roleId
	 * @param MenuId
	 * @return
	 */
	Integer insertMyMenu(@Param("roleId")String roleId,@Param("menuId")String menuId);

}
