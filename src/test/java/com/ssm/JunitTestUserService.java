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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.User;
import com.ssm.pojo.UserLevel;
import com.ssm.service.IUserService;

/**
 * @Description userService userLevelDao userDao均通过扫描包的方式注入
 * 				在使用过程中，将userService中的userLevelDao替换为本类中mock对象testUserLevelDao
 * @author fengxin
 * @date 2016年3月14日 上午9:25:46
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:test-spring-mybatis.xml" })  
public class JunitTestUserService {
	
	@Autowired
	private IUserService userService;
	
	@Mock
	private IUserLevelDao testUserLevelDao;
	
	@Before
	public void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		//将userService此bean中userLevelDao替换为本类中的userLevel1Dao
		ReflectionTestUtils.setField(AopTargetUtils.getTarget(userService), "userLevelDao", testUserLevelDao);
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
