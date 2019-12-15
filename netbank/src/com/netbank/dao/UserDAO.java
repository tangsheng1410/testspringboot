package com.netbank.dao;

import java.util.List;

import com.netbank.entity.*;


public interface UserDAO {

	//根据账户id获取账户对象
	public  Account getAccount(int accountid);
	
	//根据客户名获取客户对象
	public Account getAccount(String username);
	
	public List getAllAcconts();
	
	public Account searchAccounts(Account account);
	
	//修改账户
	public boolean updateAccount(Account account);
	
	//添加账户
	public boolean addAccount(Account account);
	
	//删除账户
	public boolean delAccount(Account account);
	

	public void reflush(Account account);
	
	//根据账户状态名称获取账户状态对象
	public Status getStatus(String name);
	
	public Status getStatus(int id);
	
	//根据username获取管理员
	public Admin getAdmin(String username);
	
	
	public boolean modifyAdmin(Admin admin);
}