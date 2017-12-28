package com.jike;

public class Employee {
	private String name;
	private Integer age;
	private String sex;
	private String job;
	private IOutputHelper iOutputHelper;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public IOutputHelper getiOutputHelper() {
		return iOutputHelper;
	}

	public void setiOutputHelper(IOutputHelper iOutputHelper) {
		this.iOutputHelper = iOutputHelper;
	}

	public String contentOutput() {
		return this.iOutputHelper.outputcontent(this);
	}
}
