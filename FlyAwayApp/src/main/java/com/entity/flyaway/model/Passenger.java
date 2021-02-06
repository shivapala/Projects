package com.entity.flyaway.model;

import javax.persistence.Column;

public class Passenger {
	@Column(name="pass_id")
	Integer pass_id;
	@Column(name="bk_id")
	Integer bk_id;
	@Column(name="Name")
	String name;
	@Column(name="Age")
	Integer age;
	public Integer getPass_id() {
		return pass_id;
	}
	public void setPass_id(Integer pass_id) {
		this.pass_id = pass_id;
	}
	public Integer getBk_id() {
		return bk_id;
	}
	public void setBk_id(Integer bk_id) {
		this.bk_id = bk_id;
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

}
