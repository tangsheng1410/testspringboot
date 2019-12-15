package com.netbank.biz.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.*;
import com.netbank.dao.*;
import com.netbank.entity.*;

//使用@Transactional注解实现事务管理
@Transactional
public class PersoninfoBizImpl implements PersoninfoBiz {
	//使用PersoninfoDao接口定义对象，并添加set方法用于依赖注入
	PersoninfoDAO personinfoDao;
	public void setPersoninfoDao(PersoninfoDAO personinfoDao) {
		this.personinfoDao = personinfoDao;
	}
	//使用UserDao接口定义对象，并添加set方法用于依赖注入
	UserDAO userDao;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 修改个人信息
	 */
	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDao.modifyPersoninfo(personinfo);
		return true;
	}
	
	/**
	 * 添加个人信息
	 */
	public boolean add(Personinfo personinfo) {
		return personinfoDao.add(personinfo);
	}
	
	/**
	 * 查询个人信息
	 */
	public List getAllPersoninfo() {
		return personinfoDao.getAllPersoninfo();
	}
	
	/**
	 * 根据条件获取个人信息
	 */
	public List searchPersoninfo(Personinfo personinfo) {
		return personinfoDao.searchPersoninfo(personinfo);
	}
	
	/**
	 * 根据账户状态获取个人信息，状态为0表示获取所有客户
	 */
	public List searchPersoninfo(Status status)
	{
		List users =new ArrayList();
		if(status.getId()!=0){		
			//如果账户状态编号不为0，则根据编号获取相应客户记录
			status=userDao.getStatus(status.getId());
			users=personinfoDao.searchPersoninfo(status);
		}else{
			//如果账户状态编号等于0，则获取所有客户记录
			users= personinfoDao.getAllPersoninfo();
		}
		return users;
	}
}
