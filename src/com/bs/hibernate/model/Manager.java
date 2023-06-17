package com.bs.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {
	@Id
	@Column(name = "id")
	private Long managerID;
	@Column(name = "man_phone")
	private String managerPhone;
	@Column(name = "man_address")
	private String managerAddress;

	@Column(name = "man_email")
	private String managerEmail;

	@Column(name = "man_name")
	private String managerName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;

	public Manager() {

	}

	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerAddress() {
		return managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Manager(Long managerID, String managerPhone, String managerAddress, String managerEmail, String managerName,
			User user, Department department) {

		this.managerID = managerID;
		this.managerPhone = managerPhone;
		this.managerAddress = managerAddress;
		this.managerEmail = managerEmail;
		this.managerName = managerName;
		this.user = user;
		this.department = department;
	}

}
