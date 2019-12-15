package com.netbank.biz.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.*;
import com.netbank.dao.*;
import com.netbank.entity.*;

//ʹ��@Transactionalע��ʵ���������
@Transactional
public class PersoninfoBizImpl implements PersoninfoBiz {
	//ʹ��PersoninfoDao�ӿڶ�����󣬲����set������������ע��
	PersoninfoDAO personinfoDao;
	public void setPersoninfoDao(PersoninfoDAO personinfoDao) {
		this.personinfoDao = personinfoDao;
	}
	//ʹ��UserDao�ӿڶ�����󣬲����set������������ע��
	UserDAO userDao;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * �޸ĸ�����Ϣ
	 */
	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDao.modifyPersoninfo(personinfo);
		return true;
	}
	
	/**
	 * ��Ӹ�����Ϣ
	 */
	public boolean add(Personinfo personinfo) {
		return personinfoDao.add(personinfo);
	}
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List getAllPersoninfo() {
		return personinfoDao.getAllPersoninfo();
	}
	
	/**
	 * ����������ȡ������Ϣ
	 */
	public List searchPersoninfo(Personinfo personinfo) {
		return personinfoDao.searchPersoninfo(personinfo);
	}
	
	/**
	 * �����˻�״̬��ȡ������Ϣ��״̬Ϊ0��ʾ��ȡ���пͻ�
	 */
	public List searchPersoninfo(Status status)
	{
		List users =new ArrayList();
		if(status.getId()!=0){		
			//����˻�״̬��Ų�Ϊ0������ݱ�Ż�ȡ��Ӧ�ͻ���¼
			status=userDao.getStatus(status.getId());
			users=personinfoDao.searchPersoninfo(status);
		}else{
			//����˻�״̬��ŵ���0�����ȡ���пͻ���¼
			users= personinfoDao.getAllPersoninfo();
		}
		return users;
	}
}
