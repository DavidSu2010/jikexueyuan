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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author SunLw
 * 学生到课程 多对多的关系
 */
@Entity
@Table(name="stu2_table")
public class Student2 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String grade;
	@ManyToMany
	@JoinTable(name="stu_course",joinColumns={@JoinColumn(name="stu_id")},
	inverseJoinColumns={@JoinColumn(name="course_id")}		
	)
	private Set<Course> courseList=new HashSet<Course>();
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
	 * @return the courseList
	 */
	public Set<Course> getCourseList() {
		return courseList;
	}
	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}
	

}
