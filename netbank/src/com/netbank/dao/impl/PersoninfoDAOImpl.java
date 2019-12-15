package com.netbank.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.netbank.dao.PersoninfoDAO;
import com.netbank.entity.*;

public class PersoninfoDAOImpl implements PersoninfoDAO {

	SessionFactory sessionFactory;	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * �޸ĸ�����Ϣ
	 */
	public void modifyPersoninfo(Personinfo personinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(personinfo);		
	}

	/**
	 * ��Ӹ�����Ϣ
	 */
	public boolean add(Personinfo personinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(personinfo);
		return true;
	}
	
	/**
	 * ��ѯȫ���û���Ϣ
	 */
	public List getAllPersoninfo() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Personinfo";		
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	/**
	 * �����˻�״̬��ȡ�û���Ϣ
	 */
	public List searchPersoninfo(Status status) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Personinfo p where p.account.status.id="+status.getId();		
		Query query = session.createQuery(hql);
		return query.list();
	}		
	
	/**
	 * ����������ѯ������Ϣ
	 */
	public List searchPersoninfo(Personinfo personinfo) {
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Personinfo.class);
		if(personinfo.getRealname()!=null&&!"".equals(personinfo.getRealname())){
			if(personinfo.getCardid()!=null){
				c.add(Restrictions.or(Restrictions.eq("realname",personinfo.getRealname()),Restrictions.eq("cardid",personinfo.getCardid())));
			}else{
				c.add(Restrictions.like("realname",personinfo.getRealname(),MatchMode.ANYWHERE));
			}					
		}
		c.addOrder(Order.asc("id"));
		return c.list();
	}

}
