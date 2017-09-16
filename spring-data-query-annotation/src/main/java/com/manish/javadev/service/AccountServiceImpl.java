package com.manish.javadev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.repository.AccountRepository;

/**
 * @author Manish
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public void setPersonDAO(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public AccountEntity createAccount(AccountEntity accountEntity) {
		AccountEntity acccountResult = accountRepository.save(accountEntity);
		return acccountResult;
	}

	@Override
	public List<AccountEntity> findByAccountType(String string) {
		return accountRepository.getByAccountType(string);
	}

	@Override
	public List<AccountEntity> findByStartDateBetween(Date startDate, Date endDate) {
		return accountRepository.getByStartDateBetween(startDate, endDate);
	}

}
