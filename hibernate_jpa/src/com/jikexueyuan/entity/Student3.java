/**
 * 
 */
package com.jikexueyuan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author SunLw
 *
 */
@Entity
public class Student3 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String grade;
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},mappedBy="stu")
	//@JoinColumn(name="student_id")
	private List<Student3Course> scList=new ArrayList<Student3Course>();
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
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the scList
	 */
	public List<Student3Course> getScList() {
		return scList;
	}
	/**
	 * @param scList the scList to set
	 */
	public void setScList(List<Student3Course> scList) {
		this.scList = scList;
	}
	
}
