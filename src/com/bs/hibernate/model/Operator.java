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
@Table(name = "operator")
public class Operator {
	@Id
	@Column(name = "id")
	private Long operatorID;

	@Column(name = "oper_phone")
	private String operPhone;

	@Column(name = "oper_address")
	private String operAddress;

	@Column(name = "oper_name")
	private String operName;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id",referencedColumnName = "id")
	private Department department;


	public Operator() {

	}

	public Long getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(Long operatorID) {
		this.operatorID = operatorID;
	}

	public String getOperPhone() {
		return operPhone;
	}

	public void setOperPhone(String operPhone) {
		this.operPhone = operPhone;
	}

	public String getOperAddress() {
		return operAddress;
	}

	public void setOperAddress(String operAddress) {
		this.operAddress = operAddress;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
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

	public Operator(Long operatorID, String operPhone, String operAddress, String operName, User user,
			Department department) {

		this.operatorID = operatorID;
		this.operPhone = operPhone;
		this.operAddress = operAddress;
		this.operName = operName;
		this.user = user;
		this.department = department;
	}

}
