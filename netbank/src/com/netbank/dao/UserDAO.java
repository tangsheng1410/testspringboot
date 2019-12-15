package com.netbank.dao;

import java.util.List;

import com.netbank.entity.*;


public interface UserDAO {

	//�����˻�id��ȡ�˻�����
	public  Account getAccount(int accountid);
	
	//���ݿͻ�����ȡ�ͻ�����
	public Account getAccount(String username);
	
	public List getAllAcconts();
	
	public Account searchAccounts(Account account);
	
	//�޸��˻�
	public boolean updateAccount(Account account);
	
	//����˻�
	public boolean addAccount(Account account);
	
	//ɾ���˻�
	public boolean delAccount(Account account);
	

	public void reflush(Account account);
	
	//�����˻�״̬���ƻ�ȡ�˻�״̬����
	public Status getStatus(String name);
	
	public Status getStatus(int id);
	
	//����username��ȡ����Ա
	public Admin getAdmin(String username);
	
	
	public boolean modifyAdmin(Admin admin);
}