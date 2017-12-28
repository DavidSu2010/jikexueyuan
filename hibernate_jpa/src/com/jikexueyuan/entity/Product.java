/**
 * 
 */
package com.jikexueyuan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * @author slw
 * 产品到类别 双向一对多 关联关系  多端
 */
@Entity
@Table(name="pro_table")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Version
	private int version;
	private String name;
	private String description;
	private Date pubTime;
	
	//建立多对一个的关联关系
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cate_id")
	private Category category;
	
	public Product(){
		
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
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	private void setVersion(int version) {
		this.version = version;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pubTime
	 */
	public Date getPubTime() {
		return pubTime;
	}

	/**
	 * @param pubTime the pubTime to set
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [description=" + description + ", id=" + id + ", name="
				+ name + ", pubTime=" + pubTime + ", version=" + version + "]";
	}
	
	
	
	
}
