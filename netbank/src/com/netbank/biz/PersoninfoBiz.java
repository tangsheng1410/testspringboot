package com.netbank.biz;

import java.util.List;

import com.netbank.entity.*;


public interface PersoninfoBiz {
	//修改个人信息
	public boolean modifyPersoninfo(Personinfo personinfo);
	
	//添加个人信息
	public boolean add(Personinfo personinfo);

	//获取全部个人信息
	public List getAllPersoninfo();
	
	//根据条件查询个人信息
	public List searchPersoninfo(Personinfo personinfo);
	
	//根据账户状态获取个人信息
	public List searchPersoninfo(Status status);
}
