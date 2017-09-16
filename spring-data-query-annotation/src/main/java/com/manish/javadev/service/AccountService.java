package com.manish.javadev.service;

import java.util.Date;
import java.util.List;

import com.manish.javadev.model.AccountEntity;

/**
 * @author Manish
 *
 */
public interface AccountService {
	AccountEntity createAccount(AccountEntity accountEntity);

	List<AccountEntity> findByAccountType(String string);
	List<AccountEntity> findByStartDateBetween(Date startDate, Date endDate);
}
