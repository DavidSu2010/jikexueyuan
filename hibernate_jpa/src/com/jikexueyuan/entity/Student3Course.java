/**
 * 
 */
package com.jikexueyuan.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author SunLw
 * 
 */
@Entity
public class Student3Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="student_id",nullable=false)
	private Student3 stu;
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="course_id",nullable=false)
	private Course2 cou;
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
	 * @return the stu
	 */
	public Student3 getStu() {
		return stu;
	}
	/**
	 * @param stu the stu to set
	 */
	public void setStu(Student3 stu) {
		this.stu = stu;
	}
	/**
	 * @return the cou
	 */
	public Course2 getCou() {
		return cou;
	}
	/**
	 * @param cou the cou to set
	 */
	public void setCou(Course2 cou) {
		this.cou = cou;
	}
	
}
