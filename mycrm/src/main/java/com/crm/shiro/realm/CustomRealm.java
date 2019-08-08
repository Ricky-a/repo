package com.crm.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.crm.pojo.UserPo;
import com.crm.service.UserLoginService;
/**
 * shiro自定义realm
 * @author admin
 *
 */
public class CustomRealm extends AuthorizingRealm {

	@Resource
	private UserLoginService userLoginService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo authenticationInfo  = new SimpleAuthorizationInfo();
		
	    UserPo	 user = (UserPo) principalCollection.getPrimaryPrincipal();
	    if(null != user){
	    	List<String> list = userLoginService.queryUserRoleList(user.getUserLoginname());
	    	Set<String> setlsit = new HashSet<>(list);
	    	authenticationInfo.setRoles(setlsit);
	    }
		return authenticationInfo;
	}

	/**
	 * 认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//1.从主体传过来的认证信息中,获取用户名
		String loginname = (String) authenticationToken.getPrincipal(); 
		
		//2.通过用户名到数据库中获取凭证
		UserPo user = userLoginService.queryUserPo(loginname);
		
		if(null == user){
			return null;
		}
		//这里第三个参数是创建CustomRealm 的名称
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserLoginname(),user.getUserPassword(),"customRealm");
		
		//设置加密的 盐(盐的值为user.getUserLoginname())
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUserLoginname()));
		
		return authenticationInfo; 
	}


	
	

}
