package com.mutongli.test;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class TestShiro {
	private static Logger LOGGER = Logger.getLogger(TestShiro.class);
	@Test
	public void testIniRealm(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//	    Factory<SecurityManager> factory2 = 
	    //2、得到SecurityManager实例 并绑定给SecurityUtils
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang123", "1234");
	    try {
	        //4、登录，即身份验证  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	LOGGER.error("", e);
	    }
//	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	    boolean result = subject.isAuthenticated();
	    LOGGER.info("登录结果:"+result);
	    //6、退出  
	    subject.logout();  
	}
	
	@Test
	public void testSimpleRealm(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//	    Factory<SecurityManager> factory2 = 
	    //2、得到SecurityManager实例 并绑定给SecurityUtils
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang123", "1234");
	    try {
	        //4、登录，即身份验证  
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	LOGGER.error("", e);
	    }
//	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	    boolean result = subject.isAuthenticated();
	    LOGGER.info("登录结果:"+result);
	    //6、退出  
	    subject.logout();  
	}
	
	
	@Test
	public void testJdbcRealm(){
		//1、获取SecurityManager工厂，此处使用Jdbc配置文件初始化SecurityManager
	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
	    //2、得到SecurityManager实例 并绑定给SecurityUtils
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
	    try {
	        //4、登录，即身份验证 
	        subject.login(token);  
	    } catch (AuthenticationException e) {  
	        //5、身份验证失败  
	    	LOGGER.error("", e);
	    }
//	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	    boolean result = subject.isAuthenticated();
	    LOGGER.info("登录结果:"+result);
	    //6、退出  
	    subject.logout();  
	}
	
}
