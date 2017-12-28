/**
 * 
 */
package com.jikexueyuan.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.jikexueyuan.entity.Account;
import com.jikexueyuan.util.HibernateUtils;

/**
 * @author slw
 * Account实体类   ---》测试类
 */
public class AccountTest {

	
	@Test
	public void add(){
		Session session=HibernateUtils.getSession();
		Transaction tx=session.beginTransaction();
		Account account=new Account();
		account.setName("zhangsan");
		account.setAge(20);
		account.setScore(88.26);
		account.setBirthday(new Date());
		session.save(account);
		tx.commit();
		session.close();
	}
	
	@Test
	public void createQueryName(){
		Session session=HibernateUtils.getSession();
		Transaction tx=session.beginTransaction();
		
		Query query=session.getNamedQuery("Account.findById");
		query.setInteger("id", 1);
		
		List<Account> list=query.list();
		for(Account a:list){
			System.out.println(a);
		}
		
		tx.commit();
		session.close();
	}
}
