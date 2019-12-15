package com.netbank.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.netbank.dao.TransactionDAO;
import com.netbank.entity.*;

public class TransactionDAOImpl implements TransactionDAO{
	
	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * �����ݱ�transaction_log����Ӽ�¼
	 */
	public boolean addLog(TransactionLog log) {
		Session session=sessionFactory.getCurrentSession();
		session.save(log);
		return true;
	}
	
	/**
	 * ��ȡ���׼�¼
	 */
	public List getLogs(Account account,int page) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(TransactionLog.class);
		c.add(Restrictions.or(Restrictions.eq("account", account), Restrictions.eq("otherid", account.getAccountid())));
		c.addOrder(Order.desc("id"));
		c.setFirstResult(10*(page-1));
		c.setMaxResults(10);
		return c.list();
		
	}
	
	/**
	 * ���ݽ����������ƻ�ȡ�������Ͷ���
	 */
	public TransactionType getTransactionType(String name) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from TransactionType t where t.name='"+name+"'";
		Query query=session.createQuery(hql);
		return (TransactionType) query.uniqueResult();		
	}
	
	/**
	 * �����ݱ�Transaction_Log�л�ȡ���˻���صĽ��׼�¼��
	 */
	public Integer getCountOfLogs(Account account){
		Session session=sessionFactory.getCurrentSession();
		String sql="select count(*) from Transaction_Log where (accountid="
			+account.getAccountid()+" or otherid="+account.getAccountid()+")";
		Query query=session.createSQLQuery(sql);
		Integer count= Integer.parseInt(query.uniqueResult().toString()) ;
		return count;
	}	
}
