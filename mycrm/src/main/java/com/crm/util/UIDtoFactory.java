package com.crm.util;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.crm.dto.MenuDto;
import com.crm.dto.RoleDto;
import com.crm.dto.UserDto;
import com.crm.pojo.MenuPo;
import com.crm.pojo.RolePo;
import com.crm.pojo.UserPo;
/**
 * 转化POJO为DTO
 * 这里使用的是ModelMapper,这是一种对象映射对象的一个包
 * @author admin
 *
 */
public class UIDtoFactory {

	/**
	 * List<UserPO>转化List<UserDto>
	 * @param userpolist
	 * @return List<UserDto> 
	 */
	public static UserDto userDtoUI(UserPo po){
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(po ,UserDto.class);
	}
	public static List<UserDto> userDtoUI(List<UserPo> userpolist){
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(userpolist ,new TypeToken<List<UserDto>>() {}.getType());
	}
	
	
	
	public static MenuDto menuDtoUI(MenuPo po) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(po, MenuDto.class);
	}
	
	public static List<MenuDto> menuDtoUI(List<MenuPo> menupolist){
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(menupolist ,new TypeToken<List<MenuDto>>() {}.getType());
	}
	
	
	
	public static RoleDto roleDtoUI(RolePo po){
		ModelMapper modelMapper = new ModelMapper();	
		return modelMapper.map(po ,RoleDto.class);
	}
	
	public static List<RoleDto> roleDtoUI(List<RolePo> rolepolist){
		ModelMapper modelMapper = new ModelMapper();	
		return modelMapper.map(rolepolist ,new TypeToken<List<RoleDto>>() {}.getType());
	}
	

	
}
