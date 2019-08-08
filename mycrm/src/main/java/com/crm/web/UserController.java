package com.crm.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Page;
import com.crm.pojo.UserPo;
import com.crm.service.UserService;
import com.crm.util.DataUtil;
import com.crm.vo.ServerResponse;


/**
 * UserController
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @RequestMapping(value = "subLogin.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<UserPo> subLogin(HttpServletRequest request,String userLoginname,String userPassword) {
    	if(userLoginname.isEmpty()){
    		return ServerResponse.createByErrorMessage("请输入用户名");
    	}
    	if(userPassword.isEmpty()){
    		return ServerResponse.createByErrorMessage("请输入密码");
    	}
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken token = new UsernamePasswordToken(userLoginname, userPassword);
    	try {
    		subject.login(token);
		} catch (Exception e) {
			e.getMessage();
			return ServerResponse.createByErrorMessage("登陆失败");
		}
		return ServerResponse.createBySuccessMessage("登陆成功");
	}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	@RequestMapping(value = "searchUserList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> searchUserList(HttpServletRequest request) {
		logger.debug("debug......UserController.......searchUserList.do");
		/** * 获取当前页   */
		int page = Integer.valueOf(request.getParameter("page") == null ? "1" : request.getParameter("page"));
		/**  * 获取每页显示的条数  */
		int rows = Integer.valueOf(request.getParameter("rows") == null ? "10" : request.getParameter("rows"));		
		
		logger.debug("debug：request....page:"+page+".....rows:"+rows);

		/** * 返回数据   */
		@SuppressWarnings("serial")
		Map<String, Object> returnMap = new HashMap<String, Object>(16) {
			{
				/** * 存放总数  */
				put("total", userService.queryCountUser());
				/** * 存放每页的数据  */
				put("rows", userService.queryUserList(new Page(page, rows)));
			}
		};
		logger.info("info.....returnMap:"+returnMap);
		return returnMap;
	}
	
	
	@RequestMapping(value = "insertUser.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<UserPo> insertUser(HttpServletRequest request, @RequestBody UserPo user) {
	    /** * 存入创建时间   */
		user.setUserCreate(DataUtil.renewDate());	
		ServerResponse<UserPo> response = userService.insertUser(user);
		System.out.println("response===>"+response);
		return response;
	}
    
	@RequestMapping(value = "updateUser.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<UserPo> updateUser(HttpServletRequest request, @RequestBody UserPo user) {
	    /** 存入更新时间  */
		user.setUserModified(DataUtil.renewDate());
		ServerResponse<UserPo> response = userService.saveUser(user);
		return response;
	}
	
	@RequestMapping(value = "deleteUser.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<UserPo> deleteUser(HttpServletRequest request,@RequestBody UserPo user) {
	    /** 存入更新时间  */
		user.setUserModified(DataUtil.renewDate());
		ServerResponse<UserPo> response = userService.removeUser(user);
		return response;
	}
	
	
	@RequestMapping(value = "initPassword.do", produces = "application/json;charset=utf-8")
	public @ResponseBody ServerResponse<UserPo> initPassword(HttpServletRequest request,@RequestBody UserPo user) {
	    /** 存入更新时间  */
		user.setUserModified(DataUtil.renewDate());
		user.setUserPassword("admin");
		int i = userService.setPassword(user);
		if(i==1){
			return ServerResponse.createBySuccessMessage("初始化密码成功");
		}		
		return ServerResponse.createByErrorMessage("初始化密码失败");
	}
	
	
	

}
