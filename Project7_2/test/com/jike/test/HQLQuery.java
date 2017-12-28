package com.jike.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.jike.entity.Users;
import com.jike.util.HibernateUtils;

public class HQLQuery {

//	 @Test
//	 public void createTable(){
//	     Configuration cfg=new Configuration().configure();
//	     SchemaExport se=new SchemaExport(cfg);
//	     se.create(true, true);
//	
//	 }

	@Test
	public void select4() {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = " from Users u where CHAR_LENGTH(u.name)=3";
			Query query = session.createQuery(hql);

			List<Users> list = (List<Users>) query.list();
			for (Users users : list) {
				String hql2 = "select count(*) from Poetries ps where ps.poet_id=? "; //
				Query query2 = session.createQuery(hql2);
				query2.setInteger(0, users.getId());
				Long count = (Long) query2.uniqueResult(); // Hibernate2.0
				System.out.println(users.getUser_name() + " - " + count);
			}

			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}

	}
	
	
}
