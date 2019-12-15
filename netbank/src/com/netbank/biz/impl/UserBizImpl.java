package com.netbank.biz.impl;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDAO;
import com.netbank.entity.*;
//ʹ��@Transactionalע��ʵ���������
@Transactional
public class UserBizImpl implements UserBiz {
	//ʹ��UserDao�ӿ��������󣬲����set��������������ע��
	UserDAO userDao;	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	//�޸��˻�	
	public boolean modifyAccount(Account account) {
		return userDao.updateAccount(account);
	}
	
	//�����˻�ID��ȡ�˻�
	@Transactional(readOnly=true)
	public Account getAccount(int accountid) {
		return userDao.getAccount(accountid);
	}
	
	//����username��ȡ�˻�
	public Account getAccount(String username) {
		return userDao.getAccount(username);
	}
	
	//����username��ȡ����Ա
	public Admin getAdmin(String username) {
		return userDao.getAdmin(username);
	}
	
	//��������˻�
	public List getAllAccounts() {
		return userDao.getAllAcconts();
	}
	
	//����˻�	
	public boolean addAccount(Account account) {
		Status status=userDao.getStatus("����");
		account.setStatus(status);
		return userDao.addAccount(account);
	}
	
	//�޸Ĺ���Ա
	public boolean modifyAdmin(Admin admin) {
		return userDao.modifyAdmin(admin);
	}
	/**
	 * ɾ���û�
	 */
	public boolean delAccount(int id) {
		//�����˻�id��ȡ�˻�
		Account account=userDao.getAccount(id);
		//ɾ���˻�����ͬʱִ�м���ɾ��
		return userDao.delAccount(account);
	}
	/**
	 * ��ѯ�˻�
	 */
	public Account searchAccounts(Account account) {
		return userDao.searchAccounts(account);
	}
	/**
	 * ��ȡ״̬
	 */
	public Status getStatus(String name) {
		return userDao.getStatus(name);
	}

	public Status getStatus(int id) {
		return userDao.getStatus(id);
	}
	
	/**
	 * �����˻�
	 */
	public void enabled(int id) {
		//�����˻���Ż�ȡ�˻�����
		Account account = userDao.getAccount(id);
		//�޸��˻������״̬���ԣ�����Ϊ����
		Status status = userDao.getStatus("����");
		account.setStatus(status);
		//�����˻�
		userDao.updateAccount(account);		
	}
	
	/**
	 * �����˻�
	 */
	public void locking(int id) {
		//�����˻���Ż�ȡ�˻�����
		Account account = userDao.getAccount(id);
		//�޸��˻������״̬���ԣ�����Ϊ����
		Status status = userDao.getStatus("����");		
		account.setStatus(status);
		//�����˻�
		userDao.updateAccount(account);
		
	}

	public void reflush(Account account) {
		userDao.reflush(account);		
	}

}
