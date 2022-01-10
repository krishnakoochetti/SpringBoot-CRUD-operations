package com.example.demo.bean;

import javax.persistence.*;

@Entity
@Table(name="Details")
public class Details {
	
	@Id
	private Long id;
	private String name;
	private String empId;
	private String tech;
	
	public Details() {
	
	}
	public Details(Long id, String name, String empId, String tech) {
		this.id = id;
		this.name = name;
		this.empId = empId;
		this.tech = tech;
	}
	public Long getId() {

		return id;
	}
	public void setId(Long id) {

		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
}
