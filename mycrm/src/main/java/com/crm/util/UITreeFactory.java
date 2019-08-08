package com.crm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONArray;
import com.crm.dto.MenuDto;
import com.crm.vo.TreeData;
import com.crm.vo.TreeVo;

public class UITreeFactory {

	private static List<TreeVo> menuTreeList = null;// 所有节点集合
	
	/** 
	 * @param menulist List<MenuDto>
	 * @param flag  为true将递归List<TreeVo>数据,false将数据转换为List<TreeVo>
	 * @return 将List<MenuDto>转化为List<TreeVo>返回JSON数据
	 */
	public static JSONArray reTreeJson(List<MenuDto> menulist,boolean flag) {		
		menuTreeList = new ArrayList<TreeVo>();
		if (flag) {
			parentTree(removeDupliById(menulist));	
			for (TreeVo treeVo : menuTreeList) {
				if(treeVo.getChildren().isEmpty()||treeVo.getChildren()==null||treeVo.getChildren().size()<0){
					treeVo.setState("open");
				}
			}
		}else {
			allTree(removeDupliById(menulist));
		}
		return (JSONArray) JSONArray.toJSON(menuTreeList);
	}
	
	
	private static void parentTree(List<MenuDto> menulist) {		
		if(menulist != null && menulist.size() > 0) {			
			for (MenuDto menu : menulist) {				
				if(menu.getMenuParentid() == 0 || menu.getMenuParentid().equals(null)) {					
					TreeData TreeData = new TreeData(menu.getMenuUrl(), 0);
					TreeVo TreeVo = new TreeVo(menu.getMenuId(), menu.getMenuName(), "open", false, TreeData,new ArrayList<TreeVo>());
					createChildrens(menulist,TreeVo);//将所用的List<MenuDto>集合,和初始化TreeVo的父节点放入进行,子节点的初始化和组装
					menuTreeList.add(TreeVo);
				}		
			}
		}
	}
	
	private static void createChildrens(List<MenuDto> menulist,TreeVo tree) {
		for (MenuDto menu : menulist) {
			//if(tree.getId()==menu.getMenuParentCode()) {
			if(tree.getId() == menu.getMenuParentid()) {
				TreeData TreeData = new TreeData(menu.getMenuUrl(), 0);
				TreeVo TreeVo = new TreeVo(menu.getMenuId(), menu.getMenuName(), "open", false, TreeData,new ArrayList<TreeVo>());
				tree.getChildren().add(TreeVo);//将子节点加入对应父节点中
				createChildrens(menulist,TreeVo);//递归调用循环
			}
		}	
	}
	
	/**
	 * 循环MenuDto转换为TreeVo
	 * @param menulist
	 */
	private static void allTree(List<MenuDto> menulist) {
		for (MenuDto menu : menulist) {
			TreeData TreeData = new TreeData(menu.getMenuUrl(), 0);
			TreeVo TreeVo = new TreeVo(menu.getMenuId(), menu.getMenuName(), "open", false, TreeData);
			menuTreeList.add(TreeVo);
		}
	}
	
		
	/**
	 * 去重
	 * @param menu
	 * @return
	 */
	private static List<MenuDto> removeDupliById(List<MenuDto> menu){
		Set<MenuDto> menuSet = new TreeSet<>((o1,o2)-> o1.getMenuName().compareTo(o2.getMenuName()));
		menuSet.addAll(menu);
		return new ArrayList<>(menuSet);
	}
	
	
	
	
	private static List<TreeVo> reTreeList(List<MenuDto> menulist) {
		menuTreeList = new ArrayList<TreeVo>();
		parentTree(removeDupliById(menulist));	
		return menuTreeList;
	}
	
	
	/**
	 *   设置Tree的Children属性时候被选中
	 * @param menulist  所有的TreeList
	 * @param mlist     需要被选中的treelist
	 * @return 
	 */
	public static JSONArray reTree(List<MenuDto> menulist, List<MenuDto> mlist) {
		List<TreeVo> treelist = reTreeList(menulist);
		List<TreeVo> tlist = reTreeList(mlist);
		for (TreeVo tree : treelist) {
			for (TreeVo treeChildren : tree.getChildren()) {
				for (TreeVo t : tlist) {
					for (TreeVo tChildren : t.getChildren()) {
						if (tChildren.getId()==treeChildren.getId()) {
							treeChildren.setChecked(true);
							tree.setState("open");
						}
					}
				}

			}

		}
		return (JSONArray) JSONArray.toJSON(treelist);
	}
	

	
}
