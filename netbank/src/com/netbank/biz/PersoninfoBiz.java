package com.netbank.biz;

import java.util.List;

import com.netbank.entity.*;


public interface PersoninfoBiz {
	//�޸ĸ�����Ϣ
	public boolean modifyPersoninfo(Personinfo personinfo);
	
	//��Ӹ�����Ϣ
	public boolean add(Personinfo personinfo);

	//��ȡȫ��������Ϣ
	public List getAllPersoninfo();
	
	//����������ѯ������Ϣ
	public List searchPersoninfo(Personinfo personinfo);
	
	//�����˻�״̬��ȡ������Ϣ
	public List searchPersoninfo(Status status);
}
