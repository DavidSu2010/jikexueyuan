/**
 * 
 */
package com.jikexueyuan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author SunLw
 * 基于外键的一对一
 */
@Entity
@Table(name="idCard2")
public class IdCard2 {

	@Id
	@GeneratedValue
	
	private int id;
	private String idCardNo; 
	  @OneToOne(mappedBy="idCard")
	private Customer2 cust;
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
	public Customer2 getCust() {
		return cust;
	}
	/**
	 * @param cust the cust to set
	 */
	public void setCust(Customer2 cust) {
		this.cust = cust;
	}
	
	
}
