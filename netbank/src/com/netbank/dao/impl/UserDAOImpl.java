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

	//�޸��˻�
	public boolean updateAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.merge(account);
		return true;
	}

	//����username��ȡ����Ա
	public Admin getAdmin(String username) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Admin as a where a.username='"+username+"'";		
		Query query = session.createQuery(hql);
		return (Admin) query.uniqueResult();
	}
	
	//�޸Ĺ���Ա
	public boolean modifyAdmin(Admin admin) {
		Session session=sessionFactory.getCurrentSession();
		session.update(admin);
		return true;
	}
	
	
	//���ݲ�ѯ������ѯ�û�
	public Account searchAccounts(Account account){		
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Account.class);
		if((account.getUsername()!=null) && !"".equals(account.getUsername())){
			c.add(Restrictions.like("username", account.getUsername(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.asc("accountid"));
		return (Account)c.list().get(0);
	}
	
	//�����˻�ID��ȡ�˻�����
	public Account getAccount(int id){
		Session session=sessionFactory.getCurrentSession();
		return (Account) session.get(Account.class, id);
	}
	
	
	//����username��ȡ�˻�
	public Account getAccount(String username) {
		Session session=sessionFactory.getCurrentSession();		
		String hql="from Account where username='"+username+"'";
		Query query = session.createQuery(hql);
		return (Account) query.uniqueResult();
	}
	
	//��ȡ�����˻�
	public List getAllAcconts() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Account ";
		Query query = session.createQuery(hql);
		return query.list();
		
	}
	//����˻�
	public boolean addAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.save(account);
		return true;
	}
	/**
	 * ɾ���˻�
	 */
	public boolean delAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(account);
		return true;
	}
	
	/**
	 *�������ƻ�ȡ״̬
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
	
	//��session�����»�ȡ����account
	public void reflush(Account account){
		Session session=sessionFactory.getCurrentSession();
		session.refresh(account);
	}
}
