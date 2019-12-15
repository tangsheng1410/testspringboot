package com.netbank.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netbank.dao.UserDAO;
import com.netbank.entity.*;

public class UserDAOImpl implements UserDAO {
	
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	//修改账户
	public boolean updateAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.merge(account);
		return true;
	}

	//根据username获取管理员
	public Admin getAdmin(String username) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Admin as a where a.username='"+username+"'";		
		Query query = session.createQuery(hql);
		return (Admin) query.uniqueResult();
	}
	
	//修改管理员
	public boolean modifyAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.update(admin);
		return true;
	}
	
	
	//根据查询条件查询用户
	public Account searchAccounts(Account account){		
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Account.class);
		if((account.getUsername()!=null) && !"".equals(account.getUsername())){
			c.add(Restrictions.like("username", account.getUsername(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.asc("accountid"));
		return (Account)c.list().get(0);
	}
	
	//根据账户ID获取账户对象
	public Account getAccount(int id){
		Session session=sessionFactory.getCurrentSession();
		return (Account) session.get(Account.class, id);
	}
	
	
	//根据username获取账户
	public Account getAccount(String username) {
		Session session=sessionFactory.getCurrentSession();		
		String hql="from Account where username='"+username+"'";
		Query query = session.createQuery(hql);
		return (Account) query.uniqueResult();
	}
	
	//获取所有账户
	public List getAllAcconts() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Account ";
		Query query = session.createQuery(hql);
		return query.list();
		
	}
	//添加账户
	public boolean addAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.save(account);
		return true;
	}
	/**
	 * 删除账户
	 */
	public boolean delAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(account);
		return true;
	}
	
	/**
	 *根据名称获取状态
	 */
	public Status getStatus(String name) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Status as s where s.name='"+name+"'";		
		Query query = session.createQuery(hql);
		return (Status) query.uniqueResult();
	}

	public Status getStatus(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Status) session.get(Status.class, id);
	}
	
	//从session中重新获取对象account
	public void reflush(Account account){
		Session session=sessionFactory.getCurrentSession();
		session.refresh(account);
	}
}
