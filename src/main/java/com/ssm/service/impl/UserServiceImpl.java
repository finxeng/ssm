package com.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.IUserDao;
import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.User;
import com.ssm.pojo.UserLevel;
import com.ssm.service.IUserService;


@Component
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserLevelDao userLevelDao;
	
	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
	@Transactional
	public int createUser(User user){
		int flag = this.userDao.insert(user);
		if(flag>0){
			UserLevel ul = new UserLevel();
			ul.setUserId(user.getId());
			ul.setUserLevel(1);
			flag = userLevelDao.insert(ul);
		}
		return flag;
	}

}
