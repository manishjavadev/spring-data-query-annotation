package com.manish.javadev;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.manish.javadev.model.AccountEntity;
import com.manish.javadev.repository.AccountRepository;
import com.manish.javadev.service.AccountService;

/**
 * @author Manish
 *
 */
@SpringBootApplication
public class SpringBootApplicationDemo implements CommandLineRunner {
	@Autowired
	static AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApplicationDemo.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		saveAccountData();
		System.out.println("Find Operation Start After Save");
		findAccountData();
		System.out.println("Done");

	}

	private void findAccountData() {
		List<AccountEntity> accountEntity = accountService.findByAccountType("Saving Account");
		for (AccountEntity resultEntity : accountEntity) {
			System.out.println("Account Entity = " + resultEntity);
		}

		System.out.println("Find By Date Between");
		Calendar calendar = Calendar.getInstance();
		Date endDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -1);
		Date startDate = calendar.getTime();

		accountEntity = accountService.findByStartDateBetween(startDate, endDate);
		for (AccountEntity resultEntity : accountEntity) {
			System.out.println("Account Entity = " + resultEntity);
		}
	}

	private void saveAccountData() {
		Calendar calendar = Calendar.getInstance();
		Date startDate = null;
		// 1
		startDate = calendar.getTime();
		AccountEntity accountEntity = new AccountEntity("Saving Account", "Manish", new Double(15000));
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 2
		calendar.add(Calendar.MONTH, -1);
		startDate = calendar.getTime();
		accountEntity = new AccountEntity("Saving Account", "Neha", new Double(15000));
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 3
		accountEntity = new AccountEntity("Saving Account", "Veena", new Double(15000));
		calendar.add(Calendar.MONTH, -2);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 4
		accountEntity = new AccountEntity("Personal Account", "Munichandra", new Double(15000));
		calendar.add(Calendar.MONTH, -3);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);

		// 5
		accountEntity = new AccountEntity("Personal Account", "Veena", new Double(15000));
		calendar.add(Calendar.MONTH, -4);
		startDate = calendar.getTime();
		accountEntity.setStartDate(startDate);
		accountService.createAccount(accountEntity);
	}
}
