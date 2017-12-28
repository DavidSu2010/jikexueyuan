/**
 * 
 */
package com.jikexueyuan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author SunLw
 * 课程到学生也是多多的关系
 */
@Entity
@Table(name="course_table")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany
	private Set<Student2> stuList=new HashSet<Student2>();
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
	 * @return the stuList
	 */
	public Set<Student2> getStuList() {
		return stuList;
	}
	/**
	 * @param stuList the stuList to set
	 */
	public void setStuList(Set<Student2> stuList) {
		this.stuList = stuList;
	}
	
}
