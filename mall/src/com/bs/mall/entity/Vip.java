package com.bs.mall.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Vip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer vipid;
	private Date joinTime;
	private String name;
	private Integer age;
	private String profession;
	private Set<Consume> consumes = new HashSet<Consume>();
	
	public Vip(){
		
	}

	public Vip(Date joinTime, String name, Integer age, String profession, Set<Consume> consumes) {
		this.joinTime = joinTime;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.consumes = consumes;
	}

	public Integer getVipid() {
		return vipid;
	}

	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Set<Consume> getConsumes() {
		return consumes;
	}

	public void setConsumes(Set<Consume> consumes) {
		this.consumes = consumes;
	}
	
	
}
