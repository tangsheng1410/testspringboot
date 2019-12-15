package com.netbank.biz;

import java.util.List;

import com.netbank.entity.*;

public interface TransactionBiz {

	//根据获取交易记录
	public List getLogs(Account account,int page);

	//转账
	public boolean transfer(TransactionLog log);
	
	//存款
	public boolean deposit(TransactionLog log);
	
	//取款
	public boolean withdrawal(TransactionLog log);	
	
	//获得账户的交易记录总数,用来初始化分页类Pager对象,并设置其perPageRows和rowCount属性	 
	public Pager getPagerOfLogs(Account account);
	
}