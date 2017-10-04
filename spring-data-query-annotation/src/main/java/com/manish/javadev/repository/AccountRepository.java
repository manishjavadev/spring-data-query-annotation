package com.manish.javadev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.model.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
	String QUERY_BY_ACCOUNT_TYPE = "SELECT a FROM AccountEntity a WHERE LOWER(a.accountType) = LOWER(?1)";
	String QUERY_BY_STARTDATE_BETWEEN = "SELECT a FROM AccountEntity a WHERE a.startDate BETWEEN ?1 and ?2)";

	@Query(QUERY_BY_ACCOUNT_TYPE)
	List<AccountEntity> getByAccountType(String string);

	@Query(QUERY_BY_STARTDATE_BETWEEN)
	List<AccountEntity> getByStartDateBetween(Date startDate, Date endDate);

	@Modifying
	void deleteByAmountIn(List<Double> amounts);
}
