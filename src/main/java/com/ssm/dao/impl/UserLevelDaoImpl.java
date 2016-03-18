package com.ssm.dao.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.ssm.dao.IUserLevelDao;
import com.ssm.pojo.UserLevel;
@Repository
public class UserLevelDaoImpl extends BaseDaoImpl<UserLevel> implements IUserLevelDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserLevel record) {
		return this.insert("com.ssm.dao.IUserLevelDao.insert", record);
	}

	@Override
	public int insertSelective(UserLevel record) {
		return this.insert("com.ssm.dao.IUserLevelDao.insertSelective", record);
	}

	@Override
	public UserLevel selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(UserLevel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(UserLevel record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
