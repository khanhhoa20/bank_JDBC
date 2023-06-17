package com.bs.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "id")
	private Long departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Operator> operatorList;
	

	public Department() {

	}


	public Long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public List<Operator> getOperatorList() {
		return operatorList;
	}


	public void setOperatorList(List<Operator> operatorList) {
		this.operatorList = operatorList;
	}


	public Department(Long departmentId, String departmentName, List<Operator> operatorList) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.operatorList = operatorList;
	}
	
}
