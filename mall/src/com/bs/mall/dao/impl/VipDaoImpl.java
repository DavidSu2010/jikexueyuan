package com.bs.mall.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.mall.dao.VipDao;
import com.bs.mall.entity.Consume;
import com.bs.mall.entity.Vip;
import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

public class VipDaoImpl implements VipDao {
    
	private SessionFactory sessionFactory;
	
	@Override
	public int addVip(Vip vip) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (int)session.save(vip);
		return id;
	}

	@Override
	public List<Vip> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select v from Vip v");
		List<Vip> vList = (List<Vip>)query.list();
		return vList;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c from Consume c");
		List<Consume> cList = (List<Consume>)query.list();
		int id = cList.size();
		return id;
	}

	@Override
	public int saveConsume(Consume consume) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (int)session.save(consume);
		return id;
	}

	@Override
	public List<Consume> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c from Consume c order by c.vip.vipid asc");
		
		int startRow = (currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Consume> cList = (List<Consume>) query.list();
		for(Consume consume:cList){
			consume.getVipid().getName();
		}
		return cList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Vip get(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return (Vip) session.get(Vip.class, id);
		
//		Query query = session.createQuery("select v from Vip v where v.id='"+id+"'");
//		List<Vip> vList = (List<Vip>) query.list();
//		Vip vip = null;
//		if(vList.size()>0){
//			vip = vList.get(0);
//		}
//		return vip;
	}

}
