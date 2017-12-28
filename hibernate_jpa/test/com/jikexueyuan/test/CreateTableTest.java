/**
 * 
 */
package com.jikexueyuan.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * @author slw
 * 生成表结构的测试类
 */
public class CreateTableTest {

	@Test
	public void createTable(){
		Configuration cfg=new Configuration().configure();
		SchemaExport se=new SchemaExport(cfg);
		se.create(true, true);
	}
}
