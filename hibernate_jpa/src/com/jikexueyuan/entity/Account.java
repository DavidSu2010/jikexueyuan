/**  

* <p>Title: Account.java</p>  
* <p>Description:</p> 
* <p>Copyright: Copyright (c) 2015</p> 
* <p>Company:</p> 
* @author 孙连伟 
* @date 2015年9月3日 下午2:37:42 
* @version V1.0
*/ 
package com.jikexueyuan.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * @author slw
 * 实体类 常用注解配置
 */
@NamedQueries(
		{@NamedQuery(name="Account.findById",query="from Account where id=:id")}
		)
@Entity
@Table(name="acc_tab")
@Cache(region="com.jikexueyuan.entity.Account",include="all",usage=CacheConcurrencyStrategy.READ_WRITE)
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4180861252869953240L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;//OID
	
	@Column(name="acc_name")
	private String name;
	@Basic(fetch=FetchType.EAGER,optional=true)
	private int age;
	private double score;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Transient
	private String address;
	
	@Lob
	private Clob content;
	@Lob
	private Blob images;
	
	@Version
	private int version;
	
	
	public Account(){
		
	}
	public Account(String name,int age){
		this.name=name;
		this.age=age;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", age=" + age
				+ ", score=" + score + ", birthday=" + birthday + "]";
	}
	/**
	 * @return the content
	 */
	public Clob getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Clob content) {
		this.content = content;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
