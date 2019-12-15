package com.netbank.dao;

import java.util.List;
import com.netbank.entity.*;

public interface TransactionDAO {

	//向数据表transaction_log中添加记录
	public boolean addLog(TransactionLog log);

	//获取交易记录
	public List getLogs(Account account,int page);
	
	//根据交易类型名称获取交易类型对象
	public TransactionType getTransactionType(String name);
	
	//获取交易记录数
	public Integer getCountOfLogs(Account account);
}