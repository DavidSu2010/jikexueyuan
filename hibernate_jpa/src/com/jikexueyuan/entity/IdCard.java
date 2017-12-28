/**
 * 
 */
package com.jikexueyuan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author SunLw
 * 基于注解的一对一关联映射
 * JPA没有提供处理共享主键生成问题的标准方法
 */
@Entity
@Table(name="idCard")
public class IdCard {

	@Id
	@GeneratedValue(generator="myfor")
	/**
	 * Hibernate自定义主键生成策略，由@GenericGenerator实现。 
		hibernate在JPA的基础上进行了扩展，可以用一下方式引入hibernate独有的主键生成策略，
		就是通过@GenericGenerator加入的。
	 */
	@GenericGenerator(name="myfor",strategy="foreign",
	parameters=@Parameter(name="property",value="cust")		
	)
	private int id;
	private String idCardNo; 
	@OneToOne(mappedBy="idCard")
	private Customer cust;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idCardNo
	 */
	public String getIdCardNo() {
		return idCardNo;
	}
	/**
	 * @param idCardNo the idCardNo to set
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	/**
	 * @return the cust
	 */
	public Customer getCust() {
		return cust;
	}
	/**
	 * @param cust the cust to set
	 */
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
}
