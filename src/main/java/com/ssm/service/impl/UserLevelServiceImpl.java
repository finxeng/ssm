package com.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.UserLevel;
import com.ssm.service.IUserLevelService;


@Component
public class UserLevelServiceImpl implements IUserLevelService {
	@Autowired
	private IUserLevelDao userLevelDao;
	@Override
	public UserLevel getUserLevelById(int id) {
		return this.userLevelDao.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int createUserLevel(UserLevel userLevel){
		return this.userLevelDao.insert(userLevel);
	}
}
