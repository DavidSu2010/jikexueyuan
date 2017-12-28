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

import com.jike.entity.Poetries;
import com.jike.entity.Poets;
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
	public void poets_list() {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = " from Poets p where CHAR_LENGTH(p.name)=3";
			Query query = session.createQuery(hql);

			List<Poets> list = (List<Poets>) query.list();
			System.out.println("Part1   ����Ϊ�����ֵ�ʫ���б���ʫ�ʵ�����ͳ��:");
			for (Poets poets : list) {
				String hql2 = "select count(*) from Poetries ps where ps.poet_id=? "; //
				Query query2 = session.createQuery(hql2);
				query2.setInteger(0, poets.getId());
				Long count = (Long) query2.uniqueResult(); // Hibernate2.0 ��ǰΪInteger���ͣ�Hibernate2.0�Ժ�ΪLong����
				System.out.println(poets.getName() + " - " + count);
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

	@Test
	public void libai_poetries() {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = " from Poetries ps join fetch ps.poet_id pd where pd.name='���'";
			Query query = session.createQuery(hql);

			List<Poetries> list = (List<Poetries>) query.list();
			int page_index = 0;
			int total_page = list.size()/10;
			if(list.size()%10!=0){
				total_page = total_page+1;
			}
			System.out.println("Part2   ���ʫ���������ʫ�ʵı���:");
			System.out.println("ʫ�������ص������ܹ�"+total_page+"ҳ��");
			for (Poetries poetries : list) {
				 int page = page_index/10+1;
				 if(page_index/10==total_page-1 && page_index%10==0){
					 System.out.println("���һҳ���ݣ�");
				 }else if(page_index%10==0){
					 System.out.println("��"+page+"ҳ���ݣ�");
				 }
				 page_index++;
				 System.out.println("��"+poetries.getTitle()+"��");
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

	
	@Test
	public void poets_query() {
		
		String poet_name;
		Scanner  poet_scan = new Scanner(System.in);
		System.out.println("Part3   ���ĳһ��ʫ�����е�ʫ��ǰ15����:");
		System.out.println("��������Ҫ��ѯ��ʫ�����֣�");
		poet_name = poet_scan.nextLine();      //  ֻ����������Ч�ַ�֮��next���������Ž���������Ŀո����Tab��Enter������Ϊ�ָ����������
		poet_name = poet_name.trim();          //  nextLine()�����Ľ�����ֻ��Enter��
		
		Transaction tx = null;
		Session session = null;
		String poetry_short = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = " from Poetries ps join fetch ps.poet_id pd where pd.name=?";
			Query query = session.createQuery(hql);
            query.setString(0, poet_name);
			List<Poetries> list = (List<Poetries>) query.list();
			int page_index = 0;
			int total_page = list.size()/10;
			if(list.size()%10!=0){
				total_page = total_page+1;
			}
			
			System.out.println("ʫ��"+poet_name+"��ص������ܹ�"+total_page+"ҳ��");
			for (Poetries poetries : list) {
				 int page = page_index/10+1;
				 if(page_index/10==total_page-1 && page_index%10==0){
					 System.out.println("���һҳ���ݣ�");
				 }else if(page_index%10==0){
					 System.out.println("��"+page+"ҳ���ݣ�");
				 }
				 page_index++;
				
				 if(poetries.getContent().length()>14){
				     poetry_short = poetries.getContent().substring(0,15);
				 }else {
					 poetry_short = poetries.getContent();
				}
				 System.out.println(poetry_short);
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
