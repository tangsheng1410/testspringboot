package com.netbank.dao;

import java.util.List;
import com.netbank.entity.*;

public interface TransactionDAO {

	//�����ݱ�transaction_log����Ӽ�¼
	public boolean addLog(TransactionLog log);

	//��ȡ���׼�¼
	public List getLogs(Account account,int page);
	
	//���ݽ����������ƻ�ȡ�������Ͷ���
	public TransactionType getTransactionType(String name);
	
	//��ȡ���׼�¼��
	public Integer getCountOfLogs(Account account);
}