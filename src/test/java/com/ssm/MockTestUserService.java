/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author fengxin
 * @date 2016年3月14日 上午9:25:46
 */
package com.ssm;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.User;
import com.ssm.pojo.UserLevel;
import com.ssm.service.IUserService;
/**
 * @Description userService、userDao均通过扫描包的方式注入，userLevelDao通过mockito:mock标签注入（注入的就是一个mock对象），
 * 				将userLevelDao从ApplicationContext中获取，
 * @author fengxin
 * @date 2016年3月14日 上午9:25:46
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:test-spring-mybatis_mock.xml" })  
public class MockTestUserService {
	
	@Autowired
    ApplicationContext ctx;
	
	@Autowired
	private IUserService userService;
	
	@Before
	public void init() throws Exception{
		IUserLevelDao userLevelDao = (IUserLevelDao) ctx.getBean("userLevelDao");
		when(userLevelDao.insert(Mockito.any(UserLevel.class))).thenReturn(1);
	}
	
	@Test
	public void testCreateUser(){
		User user = new User();
		user.setAge(1);
		user.setPassword("1");
		user.setUserName("fengxin");
		int flag = this.userService.createUser(user);
	}

}
