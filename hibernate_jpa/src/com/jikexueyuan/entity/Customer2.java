/**
 * 
 */
package com.jikexueyuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SunLw
 * 基于外键的一对一
 */
@Entity
@Table(name="customer2")
public class Customer2 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String loginName;
	  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	  @JoinColumn(name="card_id")
	private IdCard2 idCard;
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
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the idCard
	 */
	public IdCard2 getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(IdCard2 idCard) {
		this.idCard = idCard;
	}
	

}
