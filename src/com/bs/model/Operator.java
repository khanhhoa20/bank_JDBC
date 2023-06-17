package com.bs.model;

public class Operator extends User {
	private Long operatorID;
	private String operPhone;
	private String operAddress;
	private String operName;
	private String userId;
	private Long departmentId;

	public Operator() {

	}

	public Operator(Long operatorID, String operPhone, String operAddress, String operName, String userId,
			Long departmentId) {

		this.operatorID = operatorID;
		this.operPhone = operPhone;
		this.operAddress = operAddress;
		this.operName = operName;
		this.userId = userId;
		this.departmentId = departmentId;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
