package com.netbank.biz.impl;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.*;
import com.netbank.dao.*;
import com.netbank.entity.*;

//ʹ��@Transactionalע��ʵ���������
@Transactional
public class TransactionBizImpl implements TransactionBiz {
	//ʹ��TransactionDao�ӿ��������ԣ������set������������ע��
	private TransactionDAO transactionDao;
	public void setTransactionDao(TransactionDAO transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	//ʹ��UserDao�ӿ��������ԣ������set������������ע��
	private UserDAO userDao;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * ��ȡ���׼�¼
	 */
	public List getLogs(Account account,int page) {		
		return transactionDao.getLogs(account,page);
	}
	
	/**
	 * ת��
	 */	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public boolean transfer(TransactionLog log) {
		//��ȡ���˷��˻�����
		Account other=userDao.getAccount(log.getOtherid());
		//��ȡת�˷��˻�����
		Account self=log.getAccount();
		if(other!=null){
			//�޸�ת�˷��˻����
			self.setBalance(log.getAccount().getBalance()-log.getTrMoney());
			//�޸����˷��˻����
			other.setBalance(other.getBalance()+log.getTrMoney());
			//��ת�˷��˻������µ����ݱ�Account
			userDao.updateAccount(self);
			//�����˷��˻������µ����ݱ�Account
			userDao.updateAccount(other);
			//���ݽ������ͻ�ȡ�������Ͷ���
			TransactionType type = transactionDao.getTransactionType("ת��");
			log.setTransactionType(type);
			//�����ݱ�transaction_log����ӽ��׼�¼
			return  transactionDao.addLog(log);
		}
		return false;		
	}
	
	/**
	 * ���
	 */
	public boolean deposit(TransactionLog log) {
		//�ӽ�����Ϣ����log��ȡ���˻�����
		Account self=log.getAccount();
		//���˻�������������
		self.setBalance(log.getAccount().getBalance()+log.getTrMoney());
		//�����˻���Account���޸��˻����
		userDao.updateAccount(self);
		//���ݽ������ͻ�ȡ�������Ͷ���
		TransactionType type = transactionDao.getTransactionType("���");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//�����ݱ�transaction_log����ӽ��׼�¼
		return transactionDao.addLog(log);
	}
	
	/**
	 * ȡ��
	 */
	public boolean withdrawal(TransactionLog log){
		//�ӽ�����Ϣ����log��ȡ���˻�����
		Account self=log.getAccount();
		//���˻������ȡ�������
		self.setBalance(log.getAccount().getBalance()-log.getTrMoney());
		//�����˻���Account���޸��˻����
		userDao.updateAccount(self);
		//���ݽ������ͻ�ȡ�������Ͷ���
		TransactionType type = transactionDao.getTransactionType("ȡ��");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//�����ݱ�transaction_log����ӽ��׼�¼
		return transactionDao.addLog(log);
	}
	
	/**
	 * ����˻��Ľ��׼�¼������������ʼ����ҳ��Pager����
	 * ��������perPageRows��rowCount����
	 */
	public Pager getPagerOfLogs(Account account) {
		//�����ݱ�Transaction_Log�л�ȡ���˻���صĽ��׼�¼��
		int count=transactionDao.getCountOfLogs(account);
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//����pager�����е�perPageRows���ԣ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(10);
		//����pager�����е�rowCount���ԣ���ʾ��¼����
		pager.setRowCount(count);
	    //����pager����
		return pager;
	}
	
	public TransactionDAO getTransactionDao() {
		return transactionDao;
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}
	
}
