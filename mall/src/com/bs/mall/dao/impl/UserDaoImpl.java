package com.bs.mall.dao.impl;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.mall.dao.UserDao;
import com.bs.mall.entity.Role;
import com.bs.mall.entity.Users;

public class UserDaoImpl implements UserDao {
    
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Users user) {
		// TODO Auto-generated method stub
    Session session = sessionFactory.getCurrentSession();
//    Query query = (Query) session.save(user);
    session.merge(user);
	}

	@Override
	public Users getUserByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select u from Users u where u.username ='"+name+"'";
		Query query = session.createQuery(hql);
		Users user = null;
		if(query.list().size()>0){
			user = (Users) query.list().get(0);
			if(user.getRole()!=null){
				user.getRole().getRoles();
			}
		}
		return user;
	}

	@Override
	public Users getUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select u from Users u where u.username ='"+name+"' and u.password='"+password+"'";
		Query query = session.createQuery(hql);
		Users user = null;
		if(query.list().size()>0){
			user = (Users) query.list().get(0);
			if(user.getRole()!=null){
				user.getRole().getRoles();
			}
		}
		return user;
	}

	@Override
	public List<Users> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from Users u");
		
		int startRow = (currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Users> cList = (List<Users>) query.list();
		for(Users users : cList){
			if(users.getRole()!=null){
				users.getRole().getRoles();
			}
		}
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from Users u");
		List<Users> cList = (List<Users>) query.list();
		return cList.size();
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        session.merge(role);
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "select r from Role r where r.roles='"+name+"'";
		Query query = session.createQuery(hql);
		List<Role> rList = (List<Role>)query.list();
		Role role = null;
		if(rList.size() > 0){
			role = (Role)rList.get(0);
		}
		return role;
	}

}
