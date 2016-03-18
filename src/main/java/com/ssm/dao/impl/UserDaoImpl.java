package com.ssm.dao.impl;

import org.springframework.stereotype.Repository;

import com.base.dao.BaseDaoImpl;
import com.ssm.dao.IUserDao;
import com.ssm.pojo.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	@Override
	public int insert(User record) {
		return this.insert("com.ssm.dao.IUserDao.insert", record);
	}

	@Override
	public int insertSelective(User record) {
		return this.insert("com.ssm.dao.IUserDao.insertSelective", record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
