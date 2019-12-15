package com.netbank.biz;

import java.util.List;

import com.netbank.entity.*;

public interface TransactionBiz {

	//���ݻ�ȡ���׼�¼
	public List getLogs(Account account,int page);

	//ת��
	public boolean transfer(TransactionLog log);
	
	//���
	public boolean deposit(TransactionLog log);
	
	//ȡ��
	public boolean withdrawal(TransactionLog log);	
	
	//����˻��Ľ��׼�¼����,������ʼ����ҳ��Pager����,��������perPageRows��rowCount����	 
	public Pager getPagerOfLogs(Account account);
	
}