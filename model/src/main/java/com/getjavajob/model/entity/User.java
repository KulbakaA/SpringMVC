package com.getjavajob.model.entity;

import com.getjavajob.model.entity.base.AbstractEntity;

public class User extends AbstractEntity {

	private String name;
	private String lastName;

	public User() {

	}

	public User(Long id,String name, String lastName) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
