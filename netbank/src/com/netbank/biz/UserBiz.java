package com.netbank.biz;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.entity.*;

public interface UserBiz {

	/**
	 * 添加账户
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account);
	
	/**
	 * 删除账户
	 */
	public boolean delAccount(int id);

	/**
	 * 修改账户
	 * @param account
	 * @return
	 */
	public abstract boolean modifyAccount(Account account);
	
	
	/**
	 * 查询账户
	 */
	public Account searchAccounts(Account account);
	
	/**
	 * 根据账户id获取账户对象
	 * @param accountid
	 * @return
	 */
	@Transactional(readOnly = true)
	public Account getAccount(int accountid);
	
	//根据账户名称获取账户
	public Account getAccount(String username);
	
	public List getAllAccounts();
	/**
	 * 启用账户
	 */
	public void enabled(int id);
	/**
	 * 冻结账户
	 */
	public void locking(int id);
	
	//根据名称获取账户状态对象
	public Status getStatus(String name);
	
	public Status getStatus(int id);
	

	//修改管理员
	public boolean modifyAdmin(Admin admin);
	
	//根据username获取管理员
	public abstract Admin getAdmin(String username);

	public abstract void reflush(Account account);

}