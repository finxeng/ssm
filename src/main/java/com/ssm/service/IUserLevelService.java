package com.ssm.service;

import com.ssm.pojo.UserLevel;

public interface IUserLevelService {
	public UserLevel getUserLevelById(int id);  
	public int createUserLevel(UserLevel userLevel);
}
