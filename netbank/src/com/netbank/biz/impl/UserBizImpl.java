package com.netbank.biz.impl;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDAO;
import com.netbank.entity.*;
//使用@Transactional注解实现事务管理
@Transactional
public class UserBizImpl implements UserBiz {
	//使用UserDao接口声明对象，并添加set方法，用于依赖注入
	UserDAO userDao;	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	//修改账户	
	public boolean modifyAccount(Account account) {
		return userDao.updateAccount(account);
	}
	
	//根据账户ID获取账户
	@Transactional(readOnly=true)
	public Account getAccount(int accountid) {
		return userDao.getAccount(accountid);
	}
	
	//根据username获取账户
	public Account getAccount(String username) {
		return userDao.getAccount(username);
	}
	
	//根据username获取管理员
	public Admin getAdmin(String username) {
		return userDao.getAdmin(username);
	}
	
	//获得所有账户
	public List getAllAccounts() {
		return userDao.getAllAcconts();
	}
	
	//添加账户	
	public boolean addAccount(Account account) {
		Status status=userDao.getStatus("启用");
		account.setStatus(status);
		return userDao.addAccount(account);
	}
	
	//修改管理员
	public boolean modifyAdmin(Admin admin) {
		return userDao.modifyAdmin(admin);
	}
	/**
	 * 删除用户
	 */
	public boolean delAccount(int id) {
		//根据账户id获取账户
		Account account=userDao.getAccount(id);
		//删除账户对象，同时执行级联删除
		return userDao.delAccount(account);
	}
	/**
	 * 查询账户
	 */
	public Account searchAccounts(Account account) {
		return userDao.searchAccounts(account);
	}
	/**
	 * 获取状态
	 */
	public Status getStatus(String name) {
		return userDao.getStatus(name);
	}

	public Status getStatus(int id) {
		return userDao.getStatus(id);
	}
	
	/**
	 * 启用账户
	 */
	public void enabled(int id) {
		//根据账户编号获取账户对象
		Account account = userDao.getAccount(id);
		//修改账户对象的状态属性，设置为启用
		Status status = userDao.getStatus("启用");
		account.setStatus(status);
		//更新账户
		userDao.updateAccount(account);		
	}
	
	/**
	 * 冻结账户
	 */
	public void locking(int id) {
		//根据账户编号获取账户对象
		Account account = userDao.getAccount(id);
		//修改账户对象的状态属性，设置为冻结
		Status status = userDao.getStatus("冻结");		
		account.setStatus(status);
		//更新账户
		userDao.updateAccount(account);
		
	}

	public void reflush(Account account) {
		userDao.reflush(account);		
	}

}
