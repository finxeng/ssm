/** 
 * Name: com.base.dao.baseDao.java
 * Version: 1.0
 * Date: 2012-12-6
 * Author: Administrator
 */
package com.base.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;



/** 
 * 处理内容:Dao基类
 * @version: 1.0
 * @see:com.base.dao.baseDao.java 
 * @date:2012-12-6
 * @author:Administrator
 */
@Repository
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDAO<T>  {
	
	protected transient  Log log = LogFactory.getLog(getClass());
	@Resource  
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }  
	
	public List<T> query(String sqlmapper) {
		return this.getSqlSession().selectList(sqlmapper);
	}
	public List<T> quertList (String sqlmapper,T entity){
		return this.getSqlSession().selectList(sqlmapper, entity);
	}
	public T queryOne(String sqlmapper, Serializable id) {
		return this.getSqlSession().selectOne(sqlmapper, id);
	}
	
	public int update(String sqlmapper, T entity) {
		return this.getSqlSession().update(sqlmapper, entity);
	}

	public int delete(String sqlmapper, Object obj) {
		return this.getSqlSession().delete(sqlmapper, obj);
	}

	public int insert(String sqlmapper, Object obj) {
		return this.getSqlSession().insert(sqlmapper, obj);
	}
	public int delete(String sqlmapper, String id) {
		return this.getSqlSession().delete(sqlmapper, id);
	}

}
