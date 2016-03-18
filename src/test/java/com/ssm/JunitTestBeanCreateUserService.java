/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author fengxin
 * @date 2016年3月14日 上午9:25:46
 */
package com.ssm;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;
import com.ssm.dao.IUserDao;
import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.User;
import com.ssm.pojo.UserLevel;
import com.ssm.service.IUserService;

/**
 * @Description userService和userDao均采用配置文件bean定义方式实例
 * 				手动将userDao设置为userService的属性
 * 				手动将mock对象testUserLevelDao设置为userService的属性
 * @author fengxin
 * @date 2016年3月14日 上午9:25:46
 */
public class JunitTestBeanCreateUserService {
	
	private IUserService userService;
	
	private IUserDao userDao;
	
	@Mock
	private IUserLevelDao testUserLevelDao;
	
	private ApplicationContext ctx;
	
	@Before
	public void init() throws Exception{
		ctx = new ClassPathXmlApplicationContext("classpath:test-bean-spring-mybatis.xml");
		userService = (IUserService)ctx.getBean("userService");
		userDao = (IUserDao) ctx.getBean("userDao");
		MockitoAnnotations.initMocks(this);
		//将userService此bean中userLevelDao替换为本类中的testUserLevelDao
		ReflectionTestUtils.setField(AopTargetUtils.getTarget(userService), "userLevelDao", testUserLevelDao);
		ReflectionTestUtils.setField(AopTargetUtils.getTarget(userService), "userDao", userDao);
		Mockito.when(testUserLevelDao.insert(Mockito.any(UserLevel.class))).thenReturn(1);
	}
	
	@Test
	public void testCreateUser(){
		User user = new User();
		user.setAge(1);
		user.setPassword("1");
		user.setUserName("fengxin");
		int flag = this.userService.createUser(user);
		System.out.println(flag);
	}

}
