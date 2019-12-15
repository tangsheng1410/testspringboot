package com.netbank.biz;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.entity.*;

public interface UserBiz {

	/**
	 * ����˻�
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account);
	
	/**
	 * ɾ���˻�
	 */
	public boolean delAccount(int id);

	/**
	 * �޸��˻�
	 * @param account
	 * @return
	 */
	public abstract boolean modifyAccount(Account account);
	
	
	/**
	 * ��ѯ�˻�
	 */
	public Account searchAccounts(Account account);
	
	/**
	 * �����˻�id��ȡ�˻�����
	 * @param accountid
	 * @return
	 */
	@Transactional(readOnly = true)
	public Account getAccount(int accountid);
	
	//�����˻����ƻ�ȡ�˻�
	public Account getAccount(String username);
	
	public List getAllAccounts();
	/**
	 * �����˻�
	 */
	public void enabled(int id);
	/**
	 * �����˻�
	 */
	public void locking(int id);
	
	//�������ƻ�ȡ�˻�״̬����
	public Status getStatus(String name);
	
	public Status getStatus(int id);
	

	//�޸Ĺ���Ա
	public boolean modifyAdmin(Admin admin);
	
	//����username��ȡ����Ա
	public abstract Admin getAdmin(String username);

	public abstract void reflush(Account account);

}