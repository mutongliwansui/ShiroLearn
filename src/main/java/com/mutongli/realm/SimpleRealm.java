package com.mutongli.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

public class SimpleRealm implements Realm {
	private static final String REALMNAME = "simplereleam"; // realm唯一名

	public String getName() {
		return REALMNAME;
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken; // 判断是否是用户密码类型
	}
	
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token; //转化为
		String username = uptoken.getUsername();
		String password = new String(uptoken.getPassword());
		if(!"zhang123".equals(username)){
			throw new UnknownAccountException("not found User["+username+"]!");
		}
		if(!"1234".equals(password)){
			throw new IncorrectCredentialsException("incorrect Password!");
		}
		return new SimpleAuthenticationInfo(username,password,REALMNAME);
	}

}
