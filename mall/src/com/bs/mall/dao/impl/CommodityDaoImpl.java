package com.bs.mall.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.mall.dao.CommodityDao;
import com.bs.mall.entity.Commodity;

public class CommodityDaoImpl implements CommodityDao {
    
	private SessionFactory sessionFactory;
	
	@Override
	public int save(Commodity commodity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(commodity);
		return id;
	}

	@Override
	public Commodity get(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Commodity com = (Commodity) session.get(Commodity.class,id);
		return com;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c from Commodity c");
		List<Commodity> cList = (List<Commodity>)query.list();
		return cList.size();
	}

	@Override
	public List<Commodity> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c from Commodity c");
		List<Commodity> cList = (List<Commodity>)query.list();
		return cList;
	}

	@Override
	public List<Commodity> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c from Commodity c");
		
		int startRow = (currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Commodity> cList = (List<Commodity>)query.list();
		return cList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
