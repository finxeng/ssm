/** 
 * Name: com.base.dao.IBaseDAO.java
 * Version: 1.0
 * Date: 2012-12-12
 * Author: Administrator
 */
package com.base.dao;

import java.io.Serializable;
import java.util.List;

/** 
 * 处理内容:
 * @version: 1.0
 * @see:com.base.dao.IBaseDAO.java
 * @date:2012-12-12
 * @author:Administrator
 */
public interface IBaseDAO<T> {
	/**
	 * 
	 * @param sqlmapper
	 * @param obj
	 * @return
	 * @方法说明 更具ID查询数据
	 * @date 2013-1-10
	 * @author Administrator
	 */
	public T queryOne(String sqlmapper,Serializable id);
	/**
	 * 
	 * @param sqlmapper
	 * @return
	 * @方法说明 无条件查询所有数据
	 * @date 2013-1-10
	 * @author Administrator
	 */
	public List<T> query(String sqlmapper);
	/**
	 * 
	 * @param sqlmapper
	 * @param entity
	 * @return
	 * @方法说明 修改对象
	 * @date 2013-1-10
	 * @author Administrator
	 */
	public int  update(String sqlmapper,T entity);
	/**
	 * 
	 * @param sqlmapper
	 * @param obj
	 * @return
	 * @方法说明 
	 * @date 2013-1-11
	 * @author Administrator
	 */
	public int delete(String sqlmapper,Object obj);
	/**
	 * 
	 * @param sqlmapper
	 * @param id
	 * @return
	 * @方法说明 
	 * @date 2013-3-8
	 * @author Administrator
	 */
	public int delete(String sqlmapper,String id);
	/**
	 * 
	 * @param sqlmapper
	 * @param obj
	 * @return
	 * @方法说明 
	 * @date 2013-1-11
	 * @author Administrator
	 */
	public int insert(String sqlmapper,Object obj);
}
