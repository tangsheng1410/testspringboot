package com.netbank.dao;

import java.util.List;

import com.netbank.entity.*;

public interface PersoninfoDAO {
	//修改个人信息
	public void modifyPersoninfo(Personinfo personinfo);
	
	//获取全部用户信息
	public List getAllPersoninfo();
	
	//添加个人信息
	public boolean add(Personinfo personinfo);

	//根据条件查询个人信息
	public List searchPersoninfo(Personinfo personinfo);
	
	//根据账户状态获取用户信息
	public List searchPersoninfo(Status status);
}
