package com.netbank.dao;

import java.util.List;

import com.netbank.entity.*;

public interface PersoninfoDAO {
	//�޸ĸ�����Ϣ
	public void modifyPersoninfo(Personinfo personinfo);
	
	//��ȡȫ���û���Ϣ
	public List getAllPersoninfo();
	
	//��Ӹ�����Ϣ
	public boolean add(Personinfo personinfo);

	//����������ѯ������Ϣ
	public List searchPersoninfo(Personinfo personinfo);
	
	//�����˻�״̬��ȡ�û���Ϣ
	public List searchPersoninfo(Status status);
}
