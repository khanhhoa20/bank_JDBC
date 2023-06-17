package com.bs.dao;

public interface ILockBankAccountQuery {
	String UPDATE_LOCK_STATUS = "UPDATE bank_account SET lock_status = 'locked' WHERE cus_id = "
			+ " (SELECT id FROM customer WHERE cus_phone = ?)";
}
