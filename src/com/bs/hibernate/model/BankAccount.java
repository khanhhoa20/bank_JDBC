package com.bs.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount {
	@Id
	@Column(name = "id")
	private Long bankAccountId;
	@Column(name = "balance")
	private Long balance;
	@Column(name = "bank_name")
	private String bankName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cus_id", referencedColumnName = "id")
	private Customer customer;

	@OneToMany(targetEntity = Transaction.class ,mappedBy = "bankAccount", cascade = CascadeType.ALL)
	private List<Transaction> listTransactions;

	public BankAccount() {

	}

	public BankAccount(Long bankAccountId, Long balance, String bankName, Customer customer) {
		this.bankAccountId = bankAccountId;
		this.balance = balance;
		this.bankName = bankName;
		this.customer = customer;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
